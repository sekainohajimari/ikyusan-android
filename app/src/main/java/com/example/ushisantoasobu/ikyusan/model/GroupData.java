package com.example.ushisantoasobu.ikyusan.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ushisantoasobu on 15/04/26.
 */
public class GroupData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer          id;
    private String           name;
    private Integer          member_max_num;
    private Integer          topic_max_num;
    private MemberData       own_group_member;
    private ColorData        color;
    private String           created_at;
    private String           updated_at;
    private List<MemberData> groupMembers;

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
        return member_max_num;
    }

    public void setMemberMaxNum(Integer memberMaxNum) {
        this.member_max_num = memberMaxNum;
    }

    public Integer getTopicMaxNum() {
        return topic_max_num;
    }

    public void setTopicMaxNum(Integer topicMaxNum) {
        this.topic_max_num = topicMaxNum;
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

    public MemberData getOwnGroupMember() {
        return own_group_member;
    }

    public void setOwnGroupMember(MemberData ownGroupMember) {
        this.own_group_member = ownGroupMember;
    }

    public ColorData getColor() {
        return color;
    }

    public void setColor(ColorData color) {
        this.color = color;
    }
}
