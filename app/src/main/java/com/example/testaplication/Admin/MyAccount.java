package com.example.testaplication.Admin;
public class MyAccount {
    private String username;
    private String password;


    private String id;

    public MyAccount(String username, String password, String id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public MyAccount() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
