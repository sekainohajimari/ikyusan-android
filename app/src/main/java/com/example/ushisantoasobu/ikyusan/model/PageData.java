package com.example.ushisantoasobu.ikyusan.model;

import java.io.Serializable;

/**
 * Created by ushisantoasobu on 15/10/03.
 */
public class PageData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer current_page;
    private Integer next_page;
    private Integer prev_page;
    private Integer total_pages;
    private Integer total_count;

    public Integer getCurrentPage() {
        return current_page;
    }

    public void setCurrentPage(Integer currentPage) {
        this.current_page = currentPage;
    }

    public Integer getNextPage() {
        return next_page;
    }

    public void setNextPage(Integer nextPage) {
        this.next_page = nextPage;
    }

    public Integer getPrevPage() {
        return prev_page;
    }

    public void setPrevPage(Integer prevPage) {
        this.prev_page = prevPage;
    }

    public Integer getTotalPages() {
        return total_pages;
    }

    public void setTotalPages(Integer totalPages) {
        this.total_pages = totalPages;
    }

    public Integer getTotalCount() {
        return total_count;
    }

    public void setTotalCount(Integer totalCount) {
        this.total_count = totalCount;
    }
}
