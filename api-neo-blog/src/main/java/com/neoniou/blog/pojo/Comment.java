package com.neoniou.blog.pojo;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;

/**
 * @author neo.zzj
 */
public class Comment {

    @Id
    @KeySql(useGeneratedKeys = true)
    private int commentId;
    private int postId;
    private String commentContent;
    private String commentEmail;
    private String commentIp;
    private String commentDate;
    private int commentStatus;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
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

    public int getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(int commentStatus) {
        this.commentStatus = commentStatus;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", commentContent='" + commentContent + '\'' +
                ", commentEmail='" + commentEmail + '\'' +
                ", commentIp='" + commentIp + '\'' +
                ", commentDate='" + commentDate + '\'' +
                ", commentStatus=" + commentStatus +
                '}';
    }
}
