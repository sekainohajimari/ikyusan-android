package com.example.ushisantoasobu.ikyusan.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ushisantoasobu on 15/09/23.
 */
public class TopicsData implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<TopicData> topics;

    public List<TopicData> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicData> topics) {
        this.topics = topics;
    }
}
