package com.olexyn.about.java.time.patterns.message;

public class Message {
    
    private String content;
    private Producer sender;
    private Consumer receiver;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Runnable getSender() {
        return sender;
    }

    public void setSender(Producer sender) {
        this.sender = sender;
    }

    public Consumer getReceiver() {
        return receiver;
    }

    public void setReceiver(Consumer receiver) {
        this.receiver = receiver;
    }
}
