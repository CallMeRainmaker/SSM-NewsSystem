package com.hxd.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class News {
    private int id;
    private String title;
    private String abstrs;
    private String tags;
    private String photo;
    private String author;
    private String content;
    private Integer viewNumber;
    private Integer commentNumber;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstrs() {
        return abstrs;
    }

    public void setAbstrs(String abstrs) {
        this.abstrs = abstrs;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getViewNumber() {
        return viewNumber;
    }

    public void setViewNumber(Integer viewNumber) {
        this.viewNumber = viewNumber;
    }

    public Integer getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Integer commentNumber) {
        this.commentNumber = commentNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
