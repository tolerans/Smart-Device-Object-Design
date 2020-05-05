package com.company;

import java.sql.SQLException;

public interface UserDataDriver {
    void createAccount(UserData user) throws SQLException;
    void deleteAccount(String userName);

}
