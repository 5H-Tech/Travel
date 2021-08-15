package com.example.travelapp;

public class User {
    private String s_name ,
            s_email,
            s_phone,
            s_pass,User_data_id;
    private  static int id=20210;
    private int ID;
    public User(String User_data_id,String s_name, String s_email, String s_phone, String s_pass) {
        this.s_name = s_name;
        this.s_email = s_email;
        this.s_phone = s_phone;
        this.s_pass = s_pass;
        this.User_data_id=User_data_id;
        id++;
        ID=id;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getUser_data_id() {
        return User_data_id;
    }

    public void setUser_data_id(String user_data_id) {
        User_data_id = user_data_id;
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
