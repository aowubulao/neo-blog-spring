package com.neoniou.blog.pojo;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author neo.zzj
 */
public class Comment {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(generator="JDBC")
    private Integer commentId;
    private Integer postId;
    private String commentContent;
    private String commentEmail;
    private String commentIp;
    private String commentDate;
    private Integer commentStatus;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentEmail() {
        return commentEmail;
    }

    public void setCommentEmail(String commentEmail) {
        this.commentEmail = commentEmail;
    }

    public String getCommentIp() {
        return commentIp;
    }

    public void setCommentIp(String commentIp) {
        this.commentIp = commentIp;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }
}
