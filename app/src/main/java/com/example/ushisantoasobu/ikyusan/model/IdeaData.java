package com.example.ushisantoasobu.ikyusan.model;

import java.io.Serializable;

/**
 * Created by ushisantoasobu on 15/05/23.
 */
public class IdeaData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer     id;
    private Integer     topic_id;
    private Integer     poster_id;
    private String      content;
    private Boolean     anonymity;
    private Integer     likes_count;
    private String      created_at;
    private String      updated_at;
    private UserData    post_user;

    public IdeaData() {
       //
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTopicId() {
        return topic_id;
    }

    public void setTopicId(Integer topicId) {
        this.topic_id = topicId;
    }

    public Integer getPosterId() {
        return poster_id;
    }

    public void setPosterId(Integer posterId) {
        this.poster_id = posterId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getAnonymity() {
        return anonymity;
    }

    public void setAnonymity(Boolean anonymity) {
        this.anonymity = anonymity;
    }

    public Integer getLikesCount() {
        return likes_count;
    }

    public void setLikesCount(Integer likesCount) {
        this.likes_count = likesCount;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String createdAt) {
        this.created_at = createdAt;
    }

    public String getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updated_at = updatedAt;
    }

    public UserData getPostUser() {
        return post_user;
    }

    public void setPostUser(UserData postUser) {
        this.post_user = postUser;
    }
}
