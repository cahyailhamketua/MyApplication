package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class Pengguna {
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;

    public Pengguna(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
