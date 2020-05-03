package com.company;

public abstract class TemparatureSensor implements CoolerDriver {

    @Override
    public int measureTemparature() {

        int temp = 35;
        return temp;
    }
}
