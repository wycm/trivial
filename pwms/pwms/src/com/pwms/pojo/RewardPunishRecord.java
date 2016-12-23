package com.pwms.pojo;

import java.util.Date;



public class RewardPunishRecord {
    private Integer id;

    private String name;

    private Integer userId;

    private String rewPunName;

    private String reason;

    private String office;

    private String officeClass;

    private Date rewPunDate;

    private String explian;

    private Date undoDate;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRewPunName() {
        return rewPunName;
    }

    public void setRewPunName(String rewPunName) {
        this.rewPunName = rewPunName == null ? null : rewPunName.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office == null ? null : office.trim();
    }

    public String getOfficeClass() {
        return officeClass;
    }

    public void setOfficeClass(String officeClass) {
        this.officeClass = officeClass == null ? null : officeClass.trim();
    }

    public Date getRewPunDate() {
        return rewPunDate;
    }

    public void setRewPunDate(Date rewPunDate) {
        this.rewPunDate = rewPunDate;
    }

    public String getExplian() {
        return explian;
    }

    public void setExplian(String explian) {
        this.explian = explian == null ? null : explian.trim();
    }

    public Date getUndoDate() {
        return undoDate;
    }

    public void setUndoDate(Date undoDate) {
        this.undoDate = undoDate;
    }
}