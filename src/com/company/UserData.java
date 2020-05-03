package com.company;

public class UserData {

    private String userName;
    private String userPassword;
    private String userAccesType;

    public UserData(String userName, String userPassword){
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserAccesType() {
        return userAccesType;
    }

    public void setUserAccesType(String userAccesType) {
        this.userAccesType = userAccesType;
    }



}
