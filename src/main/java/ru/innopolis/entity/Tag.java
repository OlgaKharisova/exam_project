package ru.innopolis.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tag {

    @Id
    private String content;

    public Tag() {
    }

    public Tag(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
