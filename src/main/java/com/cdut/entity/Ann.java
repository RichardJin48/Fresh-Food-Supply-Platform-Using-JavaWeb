package com.cdut.entity;

import java.sql.Timestamp;

public class Ann {
    private Integer annId;
    private String title;
    private String content;
    private Timestamp releaseTime;
    private Timestamp modifiedTime;

    public Ann(Integer annId, String title, String content, Timestamp releaseTime, Timestamp modifiedTime) {
        this.annId = annId;
        this.title = title;
        this.content = content;
        this.releaseTime = releaseTime;
        this.modifiedTime = modifiedTime;
    }

    public Integer getAnnId() {
        return annId;
    }

    public void setAnnId(Integer annId) {
        this.annId = annId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Timestamp releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "Ann{" +
                "annId=" + annId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", releaseTime=" + releaseTime +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
