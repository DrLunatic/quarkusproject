package entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


import javax.persistence.Entity;

@Entity
public class Tweet extends PanacheEntity {
    private String text;
    private String username;

    public Tweet() {
    }

    public Tweet(String text, String username) {
        this.text = text;
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
