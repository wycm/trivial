package com.pwms.pojo;

public class Exam {
    private Integer id;

    private String name;

    private Integer singleScore;

    private Integer afterCourseId;

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

    public Integer getSingleScore() {
        return singleScore;
    }

    public void setSingleScore(Integer singleScore) {
        this.singleScore = singleScore;
    }

    public Integer getAfterCourseId() {
        return afterCourseId;
    }

    public void setAfterCourseId(Integer afterCourseId) {
        this.afterCourseId = afterCourseId;
    }
}