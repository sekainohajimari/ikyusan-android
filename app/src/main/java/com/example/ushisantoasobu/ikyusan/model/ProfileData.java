package com.example.ushisantoasobu.ikyusan.model;

import java.io.Serializable;

/**
 * Created by ushisantoasobu on 15/10/11.
 */
public class ProfileData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDisplayId() {
        return displayId;
    }

    public void setDisplayId(String displayId) {
        this.displayId = displayId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getDefaultIconUrl() {
        return defaultIconUrl;
    }

    public void setDefaultIconUrl(String defaultIconUrl) {
        this.defaultIconUrl = defaultIconUrl;
    }

    public Boolean getInUseDefaultIcon() {
        return inUseDefaultIcon;
    }

    public void setInUseDefaultIcon(Boolean inUseDefaultIcon) {
        this.inUseDefaultIcon = inUseDefaultIcon;
    }

    Integer     identifier;
    Integer     userId;
    String      displayId;
    String      displayName;
    String      createdAt;
    String      updatedAt;
    String      iconUrl;
    String      defaultIconUrl;
    Boolean     inUseDefaultIcon;
}
