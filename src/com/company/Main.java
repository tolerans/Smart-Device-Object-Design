package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        String newUserName;
        String newUserPassword;
        UserData user = null;
        Scanner input = new Scanner(System.in);

        UserDataDriver newUser = new UserDataPostgreSQL() {
            @Override
            public void deleteAccount(String userName) {

            }
        };

        CoolerDriver driver = new NetworkConn();
        CooolerInteraction coolerInteract = new CooolerInteraction(driver);

        coolerInteract.coolerOff();
        coolerInteract.coolerOn();
        coolerInteract.showTemparature();

        System.out.println("Create a user name:");
        newUserName=input.nextLine();
        System.out.println("Create a password:");
        newUserPassword=input.nextLine();
        user = new UserData(newUserName, newUserPassword);
        newUser.createAccount(user);

    }
}
