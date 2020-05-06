package com.company;

import java.sql.SQLException;

public interface UserDataDriver {
    void createAccount(UserData user) throws SQLException;
    void deleteAccount(String userName);
    void checkAccount(String userName, String userPassword) throws SQLException;
    int getSetFlag();
}
