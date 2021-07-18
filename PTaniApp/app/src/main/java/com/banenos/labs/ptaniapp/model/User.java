package com.banenos.labs.ptaniapp.model;

public class User {
    String id;
    String name;
    String email;
    String mobile;
    String password;

    public User(String id, String name, String email, String mobile, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }


}
