package com.example.ticket_reservation_android.models;

public class User {
    private String name;
    private String mobileNumber;
    private String email;
    private String username;
    private String password;

    public User(String name, String mobileNumber, String email, String username, String password) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
