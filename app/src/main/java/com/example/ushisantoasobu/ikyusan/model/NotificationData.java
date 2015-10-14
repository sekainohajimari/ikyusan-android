package com.example.ushisantoasobu.ikyusan.model;

import java.io.Serializable;

/**
 * Created by ushisantoasobu on 15/05/23.
 */
public class NotificationData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String notifiable_type;
    private String title;
    private String body;
    private Boolean opened;
    private String created_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNotifiableType() {
        return notifiable_type;
    }

    public void setNotifiableType(String notifiableType) {
        this.notifiable_type = notifiableType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Boolean getOpened() {
        return opened;
    }

    public void setOpened(Boolean opened) {
        this.opened = opened;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String createdAt) {
        this.created_at = createdAt;
    }
}
