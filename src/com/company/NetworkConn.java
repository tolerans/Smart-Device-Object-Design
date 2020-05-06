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
        int temp = (int)(Math.random() * 35 + 1);
        System.out.println("Room temparature :"+temp);
        return temp;
    }

    @Override
    public void showTemparature() {
        int tmp_temp = measureTemparature();
        System.out.println("Room temparature :"+tmp_temp);
    }

}


