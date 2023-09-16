package com.leng.demo;

public class Message {

    private String message;

    private int owner;

    public Message(String mMessage, int owner) {
        this.message = mMessage;
        this.owner = owner;
    }


    public int getOwner() {
        return owner;
    }

    public String getMessage() {
        return message;
    }
}
