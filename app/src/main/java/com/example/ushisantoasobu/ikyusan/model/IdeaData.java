package com.example.ushisantoasobu.ikyusan.model;

/**
 * Created by ushisantoasobu on 15/05/23.
 */
public class IdeaData {

/*
#  id          :integer          not null, primary key
#  topic_id    :integer
#  poster_id   :integer
#  content     :string(255)
#  anonymity   :integer
#  likes_count :integer          default(0)
#  created_at  :datetime         not null
#  updated_at  :datetime         not null
 */

    private Integer     id;
    private Integer     topicId;
    private Integer     posterId;
    private String      content;
    private Boolean     anonymity;
    private Integer     likesCount;
    private String      createdAt;
    private String      updatedAt;

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
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getPosterId() {
        return posterId;
    }

    public void setPosterId(Integer posterId) {
        this.posterId = posterId;
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
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
