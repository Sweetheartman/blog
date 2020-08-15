package com.jason.model.entity;

import lombok.experimental.Accessors;

@Accessors(chain = true)
public class ArticleFirstPic {

    private Integer id;
    private String fileName;
    private String fileUrl;
    private String fileKey;

    @Override
    public String toString() {
        return "ArticleFirstPic{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", fileKey='" + fileKey + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileKey() {
        return fileKey;
    }

    public void setFileKey(String fileKey) {
        this.fileKey = fileKey;
    }

    public ArticleFirstPic(){}
    public ArticleFirstPic(Integer id, String fileName, String fileUrl, String fileKey) {
        this.id = id;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
        this.fileKey = fileKey;
    }
}
