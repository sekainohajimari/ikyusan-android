package com.example.ushisantoasobu.ikyusan.model;

import java.io.Serializable;

/**
 * Created by ushisantoasobu on 15/10/11.
 */
public class ProfileData implements Serializable {

    private static final long serialVersionUID = 123456;

    public ProfileData() {
        //
    }

    private Integer     identifier;
    private Integer     user_id;
    private String      display_id;
    private String      display_name;
    private String      created_at;
    private String      updated_at;
    private String      icon_url;
    private String      default_icon_url;
    private Boolean     in_use_default_icon;

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public Integer getUserId() {
        return user_id;
    }

    public void setUserId(Integer userId) {
        this.user_id = userId;
    }

    public String getDisplayId() {
        return display_id;
    }

    public void setDisplayId(String displayId) {
        this.display_id = displayId;
    }

    public String getDisplayName() {
        return display_name;
    }

    public void setDisplayName(String displayName) {
        this.display_name = displayName;
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

    public String getIconUrl() {
        return icon_url;
    }

    public void setIconUrl(String iconUrl) {
        this.icon_url = iconUrl;
    }

    public String getDefaultIconUrl() {
        return default_icon_url;
    }

    public void setDefaultIconUrl(String defaultIconUrl) {
        this.default_icon_url = defaultIconUrl;
    }

    public Boolean getInUseDefaultIcon() {
        return in_use_default_icon;
    }

    public void setInUseDefaultIcon(Boolean inUseDefaultIcon) {
        this.in_use_default_icon = inUseDefaultIcon;
    }
}
