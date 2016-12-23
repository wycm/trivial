package com.wy.bomber.handler;

import com.alibaba.fastjson.JSON;
import com.wy.bomber.Constants;
import com.wy.bomber.httpclient.util.HttpClientUtil;
import com.wy.bomber.pojo.Source;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Map;

/**
 * Created by root on 11/3/16.
 */
public class SourceTask implements Runnable{
    private Logger logger = Logger.getLogger(SourceTask.class);
    private Source source;
    private String phoneNum;
    public static volatile boolean isStop = false;

    public SourceTask(Source source, String phoneNum) {
        this.source = source;
        this.phoneNum = phoneNum;
    }

    @Override
    public void run() {
        while (!isStop){
            execute(this.source, this.phoneNum);
            try {
                Thread.sleep((source.getTimeInterval() * 1000 )+ 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void execute(Source source, String phoneNum){
        source.setUrl(source.getUrl().replaceAll(Constants.REPLACE_PHONE_NUM, phoneNum));
        String response = null;
        if(source.getReqMethod().equals("get")){
            try {
                String url = source.getUrl().replaceAll(Constants.REPLACE_PHONE_NUM, phoneNum);
                HttpClientUtil.get(source.getUrl());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (source.getReqMethod().equals("post")){
            Map<String, String> map = (Map<String, String>) JSON.parse(source.getReqVal());
            for(String key : map.keySet()){
                String value = map.get(key);
                value = value.replaceAll(Constants.REPLACE_PHONE_NUM, phoneNum);
                map.put(key, value);
            }
            try {
                response = HttpClientUtil.post(source.getUrl(), map);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logger.info(source.getUrl() + " --- response:" + (response == null ? null : HttpClientUtil.decodeUnicode(response)));
    }
}
