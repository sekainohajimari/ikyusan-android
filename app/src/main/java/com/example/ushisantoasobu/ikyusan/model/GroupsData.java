package com.example.ushisantoasobu.ikyusan.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ushisantoasobu on 15/09/05.
 */
public class GroupsData implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<GroupData> groups;

    public List<GroupData> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupData> groups) {
        this.groups = groups;
    }
}
