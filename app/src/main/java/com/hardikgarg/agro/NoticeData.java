package com.hardikgarg.agro;

public class NoticeData {
    String name,date,time,userid,state,crop,phone,cropDate,cropMonth,cropYear;

    public NoticeData() {
    }

    public NoticeData(String name, String date, String time, String userid, String state, String phone,String crop,String cropDate,String cropMonth,String cropYear) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.userid = userid;
        this.state = state;
        this.crop = crop;
        this.phone = phone;
        this.cropMonth=cropMonth;
        this.cropYear=cropYear;
        this.cropDate=cropDate;
    }

    public String getCropDate() {
        return cropDate;
    }

    public void setCropDate(String cropDate) {
        this.cropDate = cropDate;
    }

    public String getCropMonth() {
        return cropMonth;
    }

    public void setCropMonth(String cropMonth) {
        this.cropMonth = cropMonth;
    }

    public String getCropYear() {
        return cropYear;
    }

    public void setCropYear(String cropYear) {
        this.cropYear = cropYear;
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

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
