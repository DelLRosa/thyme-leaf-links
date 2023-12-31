package com.greenhouse.Thymeleaflinks.models;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String pwHash;
    @OneToMany(mappedBy = "user")
    private List<HangSession> hangSessions;

    public User(){}

    public User(String username, String password) {
        this.username=username;
        this.pwHash= encoder.encode(password);
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public List<HangSession> getHangSessions() {
        return hangSessions;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

}
