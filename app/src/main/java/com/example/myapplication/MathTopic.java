package com.example.myapplication;

public class MathTopic {
    private String topicName;
    private int topicIcon;

    public MathTopic(String topicName, int topicIcon) {
        this.topicName = topicName;
        this.topicIcon = topicIcon;
    }

    public MathTopic() {

    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public int getTopicIcon() {
        return topicIcon;
    }

    public void setTopicIcon(int topicIcon) {
        this.topicIcon = topicIcon;
    }
}
