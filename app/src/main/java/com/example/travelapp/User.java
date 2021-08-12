package com.example.travelapp;

public class User {
    private String s_name ,
            s_email,
            s_phone,
            s_pass;

    public User(String s_name, String s_email, String s_phone, String s_pass) {
        this.s_name = s_name;
        this.s_email = s_email;
        this.s_phone = s_phone;
        this.s_pass = s_pass;
    }

    public String getS_name() {
        return s_name;
    }

    public String getS_email() {
        return s_email;
    }

    public String getS_phone() {
        return s_phone;
    }

    public String getS_pass() {
        return s_pass;
    }
}
