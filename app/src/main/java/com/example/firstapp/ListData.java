package com.example.firstapp;

public class ListData {
    private String userImage;
    private String userName;

    public ListData(String userImage, String userName){
        this.userImage = userImage;
        this.userName = userName;
    }

    public String getUserImage(){return userImage;}

    public void setUserImage(String userImage){ this.userImage = userImage;}

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName;}
}
