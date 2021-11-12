package ru.kpfu.itis.valeev.data;

import java.util.Objects;

public class ResearchGroupData {

    private String topic;
    private String description;
    private String project;
    private String words;

    public ResearchGroupData(String topic, String description, String project, String words) {
        this.topic = topic;
        this.description = description;
        this.project = project;
        this.words = words;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResearchGroupData that = (ResearchGroupData) o;
        return Objects.equals(topic, that.topic) && Objects.equals(description, that.description) && Objects.equals(project, that.project) && Objects.equals(words, that.words);
    }

    @Override
    public String toString() {
        return "ResearchGroupData{" +
                "topic='" + topic + '\'' +
                ", description='" + description + '\'' +
                ", project='" + project + '\'' +
                ", words='" + words + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic, description, project, words);
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }
}
