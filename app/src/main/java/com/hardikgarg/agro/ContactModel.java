package com.hardikgarg.agro;

public class ContactModel {
    int img;
    String heading;
     public ContactModel(int img,String heading){
         this.img=img;
         this.heading=heading;
     }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }
}
