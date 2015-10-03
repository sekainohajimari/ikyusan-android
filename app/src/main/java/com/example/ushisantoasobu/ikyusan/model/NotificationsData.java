package com.example.ushisantoasobu.ikyusan.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ushisantoasobu on 15/09/27.
 */
public class NotificationsData implements Serializable {

    private static final long serialVersionUID = 1L;

    public List<NotificationData> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationData> notifications) {
        this.notifications = notifications;
    }

    private List<NotificationData> notifications;
}
