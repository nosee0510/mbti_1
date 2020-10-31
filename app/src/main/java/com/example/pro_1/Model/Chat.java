package com.example.pro_1.Model;

import com.android.volley.toolbox.StringRequest;

public class Chat {
    private String sender;
    private String receiver;
    private String message;
    private String timestamp;
    private boolean isSeen;

    public Chat(String sender, String receiver, String message, String timestamp, boolean isSeen){
        this.sender=sender;
        this.receiver=receiver;
        this.message=message;
        this.timestamp=timestamp;
        this.isSeen=isSeen;
    }


    public Chat(){
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean seen){
        isSeen = seen;
    }
}
