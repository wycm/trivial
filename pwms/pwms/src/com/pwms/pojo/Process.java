package com.pwms.pojo;

public class Process {
    private Integer id;

    private String explian;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExplian() {
        return explian;
    }

    public void setExplian(String explian) {
        this.explian = explian == null ? null : explian.trim();
    }
}