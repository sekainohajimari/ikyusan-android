package com.example.ushisantoasobu.ikyusan.model;

import java.io.Serializable;

/**
 * Created by ushisantoasobu on 15/05/23.
 */
public class TopicData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer     id;
    private Integer     group_id;
    private Integer     builder_id;
    private String      name;
    private Integer     idea_max_num;
    private String      created_at;
    private String      updated_at;

    public TopicData() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return group_id;
    }

    public void setGroupId(Integer groupId) {
        this.group_id = groupId;
    }

    public Integer getBuilderId() {
        return builder_id;
    }

    public void setBuilderId(Integer builderId) {
        this.builder_id = builderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdeaMaxNum() {
        return idea_max_num;
    }

    public void setIdeaMaxNum(Integer ideaMaxNum) {
        this.idea_max_num = ideaMaxNum;
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

}
