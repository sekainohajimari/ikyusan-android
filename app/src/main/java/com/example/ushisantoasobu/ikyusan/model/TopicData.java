package com.example.ushisantoasobu.ikyusan.model;

/**
 * Created by ushisantoasobu on 15/05/23.
 */
public class TopicData {

/*
#  id           :integer          not null, primary key
#  group_id     :integer
#  builder_id   :integer
#  name         :string(255)
#  idea_max_num :integer
#  created_at   :datetime         not null
#  updated_at   :datetime         not null
 */

    private Integer     id;
    private Integer     groupId;
    private Integer     builderId;
    private String      name;
    private Integer     ideaMaxNum;
    private String      createdAt;
    private String      updatedAt;

    public TopicData() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getBuilderId() {
        return builderId;
    }

    public void setBuilderId(Integer builderId) {
        this.builderId = builderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdeaMaxNum() {
        return ideaMaxNum;
    }

    public void setIdeaMaxNum(Integer ideaMaxNum) {
        this.ideaMaxNum = ideaMaxNum;
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
