package com.company;

public abstract class Controller implements CoolerDriver {

    @Override
    public void coolerOn(){
        System.out.println("Cooler is opening now! with Controller");
    }

    @Override
    public void coolerOff(){
        System.out.println("Cooler is shutting down! with Controller");
    }

}

