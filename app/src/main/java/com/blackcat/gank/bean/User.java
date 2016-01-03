package com.blackcat.gank.bean;


import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("current_user_url")
    public String currentUserUrl;


    @Override
    public String toString() {
        return "User{" +
                "currentUserUrl='" + currentUserUrl + '\'' +
                '}';
    }
}
