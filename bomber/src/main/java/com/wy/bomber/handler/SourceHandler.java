package com.wy.bomber.handler;

import com.alibaba.fastjson.JSON;
import com.wy.bomber.Constants;
import com.wy.bomber.httpclient.util.HttpClientUtil;
import com.wy.bomber.pojo.Source;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * Created by root on 11/2/16.
 */
@Component
public class SourceHandler {
    private Logger logger = Logger.getLogger(Source.class);
    public void handleSource(Source source, String phoneNum){
        new Thread(new SourceTask(source, phoneNum)).start();
    }

}
