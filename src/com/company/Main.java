package com.company;

public class Main {

    public static void main(String[] args) {
        CoolerDriver driver = new NetworkConn();
        CooolerInteraction coolerInteract = new CooolerInteraction(driver);
        coolerInteract.coolerOff();
        coolerInteract.coolerOn();
        coolerInteract.showTemparature();

    }
}
