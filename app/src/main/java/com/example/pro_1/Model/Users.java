package com.example.pro_1.Model;

public class Users {

    private String id;
    private String username;
    private String imageURL;
    private String mbti;
    private String status;


    public Users() {

    }

    public Users(String id, String username, String imageURL, String mbti, String status){
        this.id = id;
        this.username = username;
        this.imageURL = imageURL;
        this.mbti = mbti;
        this.status = status;
    }


    //Getters and setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getMbti() {
        return mbti;
    }

    public void setMbti(String mbti) {
        this.mbti = mbti;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
