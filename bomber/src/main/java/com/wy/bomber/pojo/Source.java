package com.wy.bomber.pojo;

import java.sql.Timestamp;

/**
 * Created by wy on 11/1/2016.
 */
public class Source {
    private Integer id;
    private String url;
    private Integer timeInterval;
    private String reqVal;
    private String reqMethod;
    private Timestamp addTime;
    private String siteName;
    private Integer vcodeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(Integer timeInterval) {
        this.timeInterval = timeInterval;
    }

    public String getReqVal() {
        return reqVal;
    }

    public void setReqVal(String reqVal) {
        this.reqVal = reqVal;
    }

    public String getReqMethod() {
        return reqMethod;
    }

    public void setReqMethod(String reqMethod) {
        this.reqMethod = reqMethod;
    }

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Integer getVcodeId() {
        return vcodeId;
    }

    public void setVcodeId(Integer vcodeId) {
        this.vcodeId = vcodeId;
    }
}
