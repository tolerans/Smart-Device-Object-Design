package com.company;

public interface UserDataDriver {
    void createAccount(UserData userName, UserData userPassword);
    void deleteAccount(String userName);
}
