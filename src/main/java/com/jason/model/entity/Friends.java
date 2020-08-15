package com.jason.model.entity;

import lombok.experimental.Accessors;

@Accessors(chain = true)
public class Friends {

    private Integer id;
    private String name;
    private String gender;
    private String blogurl;
    private String imgurl;
    private String phone;
    private String mail;
    private String description;

    @Override
    public String toString() {
        return "Friends{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", blogurl='" + blogurl + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

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
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBlogurl() {
        return blogurl;
    }

    public void setBlogurl(String blogurl) {
        this.blogurl = blogurl;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Friends(){}
    public Friends(Integer id, String name, String gender, String blogurl, String imgurl, String phone, String mail, String description) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.blogurl = blogurl;
        this.imgurl = imgurl;
        this.phone = phone;
        this.mail = mail;
        this.description = description;
    }
}
