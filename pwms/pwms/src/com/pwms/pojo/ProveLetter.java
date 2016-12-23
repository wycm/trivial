package com.pwms.pojo;

import java.util.Date;

public class ProveLetter {
    private Integer id;

    private String name;

    private String sex;

    private String orignUnit;

    private String partyMemberType;

    private Date publishDate;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getOrignUnit() {
        return orignUnit;
    }

    public void setOrignUnit(String orignUnit) {
        this.orignUnit = orignUnit == null ? null : orignUnit.trim();
    }

    public String getPartyMemberType() {
        return partyMemberType;
    }

    public void setPartyMemberType(String partyMemberType) {
        this.partyMemberType = partyMemberType == null ? null : partyMemberType.trim();
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}