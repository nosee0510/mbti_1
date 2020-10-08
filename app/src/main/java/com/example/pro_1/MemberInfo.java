package com.example.pro_1;
public class MemberInfo {
    private String name;
    private String phoneNumber;
    private String mbti;
    private String birthDay;
    private String address;

    public MemberInfo(){

    }

    public MemberInfo(String name, String mbti, String birthDay, String address){
        this.name = name;
        this.mbti = mbti;
        this.birthDay = birthDay;
        this.address = address;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getMbti(){
        return this.mbti;
    }
    public void setMbti(String mbti){
        this.mbti = mbti;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getBirthDay(){
        return this.birthDay;
    }
    public void setBirthDay(String birthDay){
        this.birthDay = birthDay;
    }
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }
}