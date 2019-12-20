package com.neoniou.blog.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author neo.zzj
 */
@Table(name = "nb_post")
public class Post {

    @Id
    @Column(name = "post_id")
    @GeneratedValue(generator="JDBC")
    private Integer postId;
    private String postAuthor;
    private String postDate;
    private String postTitle;
    private String postContent;
    private String postExcerpt;
    private Integer postStatus;
    private Integer commentStatus;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(String postAuthor) {
        this.postAuthor = postAuthor;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostExcerpt() {
        return postExcerpt;
    }

    public void setPostExcerpt(String postExcerpt) {
        this.postExcerpt = postExcerpt;
    }

    public Integer getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(Integer postStatus) {
        this.postStatus = postStatus;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postAuthor='" + postAuthor + '\'' +
                ", postDate='" + postDate + '\'' +
                ", postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                ", postExcerpt='" + postExcerpt + '\'' +
                ", postStatus=" + postStatus +
                ", commentStatus=" + commentStatus +
                '}';
    }
}
