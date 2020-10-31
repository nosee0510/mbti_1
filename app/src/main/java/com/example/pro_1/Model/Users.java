package com.example.pro_1.Model;

public class Users {

    private String id;
    private String username;
    private String imageURL;
    private String mbti;
    private String age;
    private String addr;
    private String status;
    private String sex;


    public Users() {

    }

    public Users(String id, String username, String imageURL, String mbti, String age, String addr, String status,String sex){
        this.id = id;
        this.username = username;
        this.imageURL = imageURL;
        this.mbti = mbti;
        this.age = age;
        this.addr = addr;
        this.status = status;
        this.sex = sex;
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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex(){
        return sex;
    }

    public void sexSex(String sex){
        this.sex = sex;
    }
}
