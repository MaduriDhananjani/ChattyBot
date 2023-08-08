package com.example.chattybot;

public class MsgModal {

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    private String cnt;

    public MsgModal(String cnt) {
        this.cnt = cnt;
    }
}
