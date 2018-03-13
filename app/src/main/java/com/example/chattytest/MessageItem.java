package com.example.chattytest;

import java.util.Date;

/**
 * Created by 艾德米 on 2018/3/12.
 */

public class MessageItem {
    private String fromUser;
    private String fromUserAvatar;
    private String toUser;
    private String toUserAvatar;
    private String strMsg;
    private Date date;

    public MessageItem(String fromUser, String fromUserAvatar, String toUser, String toUserAvatar, String strMsg) {
        this.fromUser = fromUser;
        this.fromUserAvatar = fromUserAvatar;
        this.toUser = toUser;
        this.toUserAvatar = toUserAvatar;
        this.strMsg = strMsg;
        this.date = new Date();
    }

    public MessageItem(){
        this.fromUser = "";
        this.fromUserAvatar = "";
        this.toUser = "";
        this.toUserAvatar = "";
        this.strMsg = "";
        this.date = new Date();
    }

    public String getFromUserAvatar() {
        return fromUserAvatar;
    }

    public void setFromUserAvatar(String fromUserAvatar) {
        this.fromUserAvatar = fromUserAvatar;
    }

    public String getToUserAvatar() {
        return toUserAvatar;
    }

    public void setToUserAvatar(String toUserAvatar) {
        this.toUserAvatar = toUserAvatar;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStrMsg() {
        return strMsg;
    }

    public void setStrMsg(String strMsg) {
        this.strMsg = strMsg;
    }

    @Override
    public String toString() {
        return strMsg;
    }
}
