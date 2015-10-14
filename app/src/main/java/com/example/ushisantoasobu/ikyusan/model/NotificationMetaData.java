package com.example.ushisantoasobu.ikyusan.model;

import java.io.Serializable;

/**
 * Created by ushisantoasobu on 15/10/03.
 */
public class NotificationMetaData implements Serializable {

    private static final long serialVersionUID = 1L;

    private PageData pagination;

    public PageData getPagination() {
        return pagination;
    }

    public void setPagination(PageData pagination) {
        this.pagination = pagination;
    }

}
