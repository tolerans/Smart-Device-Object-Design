package com.company;


import java.sql.SQLException;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) throws SQLException {
        String newUserName;
        String newUserPassword;
        String newUserAccessType;
        String choose;
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
        System.out.println("  ____            _              ____            _             _ _            __     ___   ___  \n" +
                " / ___|___   ___ | | ___ _ __   / ___|___  _ __ | |_ _ __ ___ | | | ___ _ __  \\ \\   / / | / _ \\ \n" +
                "| |   / _ \\ / _ \\| |/ _ \\ '__| | |   / _ \\| '_ \\| __| '__/ _ \\| | |/ _ \\ '__|  \\ \\ / /| || | | |\n" +
                "| |__| (_) | (_) | |  __/ |    | |__| (_) | | | | |_| | | (_) | | |  __/ |      \\ V / | || |_| |\n" +
                " \\____\\___/ \\___/|_|\\___|_|     \\____\\___/|_| |_|\\__|_|  \\___/|_|_|\\___|_|       \\_/  |_(_)___/ ");

        System.out.println("If you have an account, sign in by pressing 'L'.");
        System.out.println("If you do not have an account, register by pressing 'N'.");
        choose = input.nextLine();

        while (!choose.matches("q|Q"))
        {

            if(choose.matches("l|L")){
                System.out.println("Please enter a user name:");
                newUserName = input.next();
                System.out.println("Please enter a password:");
                newUserPassword = input.next();
                newUser.checkAccount(newUserName , newUserPassword);

            }
            if(choose.matches("n|N")){
                System.out.println("Receiving new registration");
                System.out.println("Create a user name:");
                newUserName = input.next();
                System.out.println("Create a password:");
                newUserPassword = input.next();
                System.out.println("Create a user access type:");
                newUserAccessType = input.next();
                user = new UserData(newUserName, newUserPassword, newUserAccessType);
                newUser.createAccount(user);
                System.out.println("The new record has been successfully updated");
                break;
            }
            else{
                System.out.println("Please make the right choice 'L Or l' and 'N or n'");

            }

        }


    }
}
