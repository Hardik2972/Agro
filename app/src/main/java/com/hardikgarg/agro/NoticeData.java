package com.hardikgarg.agro;

public class NoticeData {
    String name,date,time,userid,state,crop,phone;

    public NoticeData() {
    }

    public NoticeData(String name, String date, String time, String userid, String state, String phone) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.userid = userid;
        this.state = state;
//        this.crop = crop;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserid() {
        return userid;
    }

     public void setUserid(String email) {
        this.userid= userid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

//    public String getCrop() {
//        return crop;
//    }
//
//    public void setCrop(String crop) {
//        this.crop = crop;
//    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
