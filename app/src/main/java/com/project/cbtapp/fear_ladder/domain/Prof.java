package com.project.cbtapp.fear_ladder.domain;

public class Prof {

    private  String email;
    private String username;

    public Prof() {
    }

    public Prof(String email,String username) {
        this.email = email;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
