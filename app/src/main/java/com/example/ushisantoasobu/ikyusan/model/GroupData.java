package com.example.ushisantoasobu.ikyusan.model;

/**
 * Created by ushisantoasobu on 15/04/26.
 */
public class GroupData {

    private Integer     id;
    private String      name;
    private Integer     memberMaxNum;
    private Integer     topicMaxNum;
    private MemberData  ownGroupMember;
    private ColorData   color;
    private String      createdAt;
    private String      updatedAt;

    public GroupData() {
        //
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

    public Integer getMemberMaxNum() {
        return memberMaxNum;
    }

    public void setMemberMaxNum(Integer memberMaxNum) {
        this.memberMaxNum = memberMaxNum;
    }

    public Integer getTopicMaxNum() {
        return topicMaxNum;
    }

    public void setTopicMaxNum(Integer topicMaxNum) {
        this.topicMaxNum = topicMaxNum;
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

    public MemberData getOwnGroupMember() {
        return ownGroupMember;
    }

    public void setOwnGroupMember(MemberData ownGroupMember) {
        this.ownGroupMember = ownGroupMember;
    }

    public ColorData getColor() {
        return color;
    }

    public void setColor(ColorData color) {
        this.color = color;
    }
}
