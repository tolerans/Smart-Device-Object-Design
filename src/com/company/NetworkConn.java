package com.company;


public class NetworkConn implements CoolerDriver {

    @Override
    public void coolerOn() {
        System.out.println("Cooler is opening now! ");
    }

    @Override
    public void coolerOff() {
        System.out.println("Cooler is shutting now! ");
    }

    @Override
    public int measureTemparature() {
        int temp = (int)(Math.random() * 50 + 1);
        return temp;
    }

    @Override
    public void showTemparature() {
        System.out.println(measureTemparature());
    }

}


