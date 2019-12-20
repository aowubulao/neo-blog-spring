package com.neoniou.blog.pojo;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;

/**
 * @author neo.zzj
 */
public class User {

    @Id
    @KeySql(useGeneratedKeys = true)
    private int userId;
    private String username;
    private String userEmail;
    private String password;
    private String url;
    private String blogName;
    private String blogSubName;
    private String blogDescription;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogSubName() {
        return blogSubName;
    }

    public void setBlogSubName(String blogSubName) {
        this.blogSubName = blogSubName;
    }

    public String getBlogDescription() {
        return blogDescription;
    }

    public void setBlogDescription(String blogDescription) {
        this.blogDescription = blogDescription;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                ", blogName='" + blogName + '\'' +
                ", blogSubName='" + blogSubName + '\'' +
                ", blogDescription='" + blogDescription + '\'' +
                '}';
    }
}
