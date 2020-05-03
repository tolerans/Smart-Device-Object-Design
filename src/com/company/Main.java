package com.company;

public class Main {

    public static void main(String[] args) {
        CoolerDriver driver = new NetworkConn();
        driver.coolerOff();
        driver.coolerOn();
        driver.showTemparature();

    }
}
