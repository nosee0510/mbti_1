package com.example.pro_1.notifications;

public class Token {
    String username;

    String token;

    public Token(String token){
        this.token = token;
    }

    public Token(){

    }

    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }
}
