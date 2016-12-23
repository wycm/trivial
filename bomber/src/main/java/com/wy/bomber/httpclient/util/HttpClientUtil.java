package com.wy.bomber.httpclient.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.*;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BestMatchSpecFactory;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Asserts;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.LoggerFactory;

import us.codecraft.webmagic.utils.UrlUtils;

public class HttpClientUtil {
	private final static Logger LOG = Logger.getLogger(HttpClientUtil.class);

	private final static int socketTimeout = 30000;
	private final static int connectTimeout = 30000;
	private final static String userAgent =
			"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.110 Safari/537.36";

	private static HttpHost proxy;
	private static CloseableHttpClient httpClient;
	private static RequestConfig requestConfig;

	static {
		init();
	}

	private static void init() {
		try {
			SSLContext sslContext =
					SSLContexts.custom()
							.loadTrustMaterial(KeyStore.getInstance(KeyStore.getDefaultType()), new TrustStrategy() {
								@Override
								public boolean isTrusted(X509Certificate[] chain, String authType)
										throws CertificateException {
									return true;
								}
							}).build();
			SSLConnectionSocketFactory sslSFactory =
					new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

			Registry<ConnectionSocketFactory> socketFactoryRegistry =
					RegistryBuilder.<ConnectionSocketFactory>create()
							.register("http", PlainConnectionSocketFactory.INSTANCE).register("https", sslSFactory)
							.build();

			PoolingHttpClientConnectionManager connManager =
					new PoolingHttpClientConnectionManager(socketFactoryRegistry);

			SocketConfig socketConfig = SocketConfig.custom().setTcpNoDelay(true).build();
			connManager.setDefaultSocketConfig(socketConfig);

			ConnectionConfig connectionConfig =
					ConnectionConfig.custom().setMalformedInputAction(CodingErrorAction.IGNORE)
							.setUnmappableInputAction(CodingErrorAction.IGNORE).setCharset(Consts.UTF_8).build();
			connManager.setDefaultConnectionConfig(connectionConfig);

			connManager.setMaxTotal(300);
			connManager.setDefaultMaxPerRoute(300);

			HttpRequestRetryHandler retryHandler = new HttpRequestRetryHandler() {
				@Override
				public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
					if (executionCount > 3) {
						return false;
					}
					if (exception instanceof InterruptedIOException) {
						return true;
					}
					if (exception instanceof ConnectTimeoutException) {
						return true;
					}
					if (exception instanceof UnknownHostException) {
						return true;
					}
					if (exception instanceof SSLException) {
						return true;
					}
					HttpRequest request = HttpClientContext.adapt(context).getRequest();
					if (!(request instanceof HttpEntityEnclosingRequest)) {
						return true;
					}
					return false;
				}
			};

			HttpClientBuilder httpClientBuilder =
					HttpClients.custom().setConnectionManager(connManager).setRetryHandler(retryHandler)
							.setDefaultCookieStore(new BasicCookieStore()).setUserAgent(userAgent);
			if (proxy != null) {
				httpClientBuilder.setRoutePlanner(new DefaultProxyRoutePlanner(proxy)).build();
			}
			httpClient = httpClientBuilder.build();

			requestConfig =
					RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
		} catch (Exception e) {
			LOG.error("create httpclient failed", e);
		}
	}

	public static void setProxy(String hostName, int port) {
		proxy = new HttpHost(hostName, port);
	}

	/**
	 * get请求
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static String get(String url) throws IOException {
		Asserts.notNull(httpClient, "httpClient");

		HttpGet httpGet = new HttpGet(url);
		httpGet.setConfig(requestConfig);

		try (CloseableHttpResponse response = execute(httpGet)) {
			int status = response.getStatusLine().getStatusCode();
			if (status == 200) {
				return getContent(response);
			}
			throw new IOException(url + ", status: " + status);
		} catch (IOException e) {
			throw e;
		}
	}

	private static String getContent(HttpResponse httpResponse) throws IOException {
		HttpEntity entity = httpResponse.getEntity();
		if (entity == null) {
			return null;
		}

		InputStream instream = null;
		Header encoding = entity.getContentEncoding();
		if (encoding != null && encoding.getValue() != null && encoding.getValue().toLowerCase().contains("gzip")) {
			instream = new GZIPInputStream(entity.getContent());
		} else {
			instream = entity.getContent();
		}

		byte[] contentBytes = IOUtils.toByteArray(instream);
		String htmlCharset = getHtmlCharset(httpResponse, contentBytes);
		if (htmlCharset != null) {
			return new String(contentBytes, htmlCharset);
		}
		return new String(contentBytes);
	}

	private static String getHtmlCharset(HttpResponse httpResponse, byte[] contentBytes) throws IOException {
		String charset;
		// charset
		// 1、encoding in http header Content-Type
		String value = httpResponse.getEntity().getContentType().getValue();
		charset = UrlUtils.getCharset(value);
		if (StringUtils.isNotBlank(charset)) {
			LOG.debug("Auto get charset: {" + charset +"}");
			return charset;
		}
		// use default charset to decode first time
		Charset defaultCharset = Charset.defaultCharset();
		String content = new String(contentBytes, defaultCharset.name());
		// 2、charset in meta
		if (StringUtils.isNotEmpty(content)) {
			Document document = Jsoup.parse(content);
			Elements links = document.select("meta");
			for (Element link : links) {
				// 2.1、html4.01 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
				// />
				String metaContent = link.attr("content");
				String metaCharset = link.attr("charset");
				if (metaContent.indexOf("charset") != -1) {
					metaContent = metaContent.substring(metaContent.indexOf("charset"), metaContent.length());
					charset = metaContent.split("=")[1];
					break;
				}
				// 2.2、html5 <meta charset="UTF-8" />
				else if (StringUtils.isNotEmpty(metaCharset)) {
					charset = metaCharset;
					break;
				}
			}
		}
		LOG.debug("Auto get charset: {" + charset + "}");
		// 3、todo use tools as cpdetector for content decode
		return charset;
	}

	public static File getFile(String url, String filePath) throws IOException {
		if (httpClient == null) {
			throw new IllegalStateException("httpClient is null");
		}

		HttpGet httpGet = new HttpGet(url);
		httpGet.setConfig(requestConfig);

		CloseableHttpResponse response = null;
		File file = new File(filePath);

		try {
			response = execute(httpGet);

			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream is = null;
				Header h = response.getFirstHeader("Content-Encoding");
				if (h != null && h.getValue() != null && h.getValue().toLowerCase().contains("gzip")) {
					is = new GZIPInputStream(entity.getContent());
				} else {
					is = entity.getContent();
				}

				BufferedInputStream bis = new BufferedInputStream(is);
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));

				byte[] b = new byte[1024];
				int len = 0;
				while ((len = bis.read(b)) != -1) {
					bos.write(b, 0, len);
				}
				bos.flush();

				bis.close();
				bos.close();
				LOG.info("get file finished");
			}
		} catch (IOException e) {
			LOG.error("getFile error, url: {" + url + "}");
			throw e;
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return file;
	}

	// 发送POST 请求
	public static String post(String url, Map<String, String> params) throws IOException {
		if (httpClient == null) {
			throw new IllegalStateException("httpClient is null");
		}

		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(requestConfig);

		List<NameValuePair> formParams = new ArrayList<NameValuePair>();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		httpPost.setEntity(new UrlEncodedFormEntity(formParams, Consts.UTF_8));

		CloseableHttpResponse response = null;
		String result = null;

		try {
			response = execute(httpPost);

			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}
	private static CloseableHttpResponse execute(HttpRequestBase requestBase) throws IOException {
		if(proxy != null){
			return httpClient.execute(proxy, requestBase);
		}
		else {
			return httpClient.execute(requestBase);
		}
	}
	/**
	 *
	 * unicode转化String
	 * 有bug 慎用
	 * @return
	 */
	public static String decodeUnicode(String dataStr) {
		int start = 0;
		int end = 0;
		final StringBuffer buffer = new StringBuffer();
		while (start > -1) {
			start = dataStr.indexOf("\\u", start - (6 - 1));
			if (start == -1){
				break;
			}
			start = start + 2;
			end = start + 4;
			String tempStr = dataStr.substring(start, end);
			String charStr = "";
			charStr = dataStr.substring(start, end);
			char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
			dataStr = dataStr.replace("\\u" + tempStr, letter + "");
			start = end;
		}
		return dataStr;
	}
}
