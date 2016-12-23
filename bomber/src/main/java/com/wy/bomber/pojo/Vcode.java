package com.wy.bomber.pojo;

import java.sql.Timestamp;

/**
 * Created by wy on 11/2/2016.
 */
public class Vcode {
    private Integer id;
    private String url;
    private Timestamp addTime;
    private Integer vcodeType;

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

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public Integer getVcodeType() {
        return vcodeType;
    }

    public void setVcodeType(Integer vcodeType) {
        this.vcodeType = vcodeType;
    }
}
