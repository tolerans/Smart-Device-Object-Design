package com.company;

public interface CoolerDriver {
    public void  coolerOn();
    public void  coolerOff();
    public int measureTemparature();
    abstract void showTemparature();
}
