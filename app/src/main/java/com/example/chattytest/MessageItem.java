package com.example.chattytest;

import java.util.Date;

/**
 * Created by 艾德米 on 2018/3/12.
 */

public class MessageItem {
    private String fromUser;
    private int fromUserAvatar;
    private String toUser;
    private String strMsg;
    private Date date;

    private int TAG;

    public MessageItem(String fromUser, int fromUserAvatar, String toUser, String toUserAvatar, String strMsg) {
        this.fromUser = fromUser;
        this.fromUserAvatar = fromUserAvatar;
        this.toUser = toUser;
        this.strMsg = strMsg;
        this.date = new Date();
    }

    public MessageItem(){
        this.fromUser = "";
        this.fromUserAvatar = 0;
        this.toUser = "";
        this.strMsg = "";
        this.date = new Date();
    }

    public int getTAG() {
        return TAG;
    }

    /**
     * 0:用户自己
     * 1:对方
     * */
    public void setTAG(int TAG) {
        this.TAG = TAG;
    }

    public int getFromUserAvatar() {
        return fromUserAvatar;
    }

    public void setFromUserAvatar(int fromUserAvatar) {
        this.fromUserAvatar = fromUserAvatar;
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
