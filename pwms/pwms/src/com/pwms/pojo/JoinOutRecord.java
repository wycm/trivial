package com.pwms.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class JoinOutRecord {
    private Integer id;

    private String name;

    private String outUnit;

    private String joinUnit;
    @DateTimeFormat(pattern="yyyy-MM-dd")  
    private Date outDate;

    private String originContactAddress;

    private String originContactPhone;

    private String destAgent;

    private String destAgentPhone;
    @DateTimeFormat(pattern="yyyy-MM-dd")  
    private Date joinDate;

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

    public String getOutUnit() {
        return outUnit;
    }

    public void setOutUnit(String outUnit) {
        this.outUnit = outUnit == null ? null : outUnit.trim();
    }

    public String getJoinUnit() {
        return joinUnit;
    }

    public void setJoinUnit(String joinUnit) {
        this.joinUnit = joinUnit == null ? null : joinUnit.trim();
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String getOriginContactAddress() {
        return originContactAddress;
    }

    public void setOriginContactAddress(String originContactAddress) {
        this.originContactAddress = originContactAddress == null ? null : originContactAddress.trim();
    }

    public String getOriginContactPhone() {
        return originContactPhone;
    }

    public void setOriginContactPhone(String originContactPhone) {
        this.originContactPhone = originContactPhone == null ? null : originContactPhone.trim();
    }

    public String getDestAgent() {
        return destAgent;
    }

    public void setDestAgent(String destAgent) {
        this.destAgent = destAgent == null ? null : destAgent.trim();
    }

    public String getDestAgentPhone() {
        return destAgentPhone;
    }

    public void setDestAgentPhone(String destAgentPhone) {
        this.destAgentPhone = destAgentPhone == null ? null : destAgentPhone.trim();
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}