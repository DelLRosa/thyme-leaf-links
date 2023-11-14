package com.greenhouse.Thymeleaflinks.models;

import javax.persistence.*;

@Entity
public class HangSession {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String date;
    private int weight;

    public HangSession() {}
    public HangSession(User user, String date, int weight) {
        this.user = user;
        this.date = date;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
