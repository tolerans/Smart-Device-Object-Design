package com.company;

public class CooolerInteraction {

    private final CoolerDriver whichInteraction;

    //Constractor
    public CooolerInteraction(CoolerDriver whichInteraction){
        this.whichInteraction = whichInteraction;
    }

    public void coolerOn(){
        whichInteraction.coolerOn();
    }

    public void coolerOff(){
        whichInteraction.coolerOff();
    }

    public int measureTemparature() {
        whichInteraction.measureTemparature();
        return 0;
    }

    public void showTemparature() {
        whichInteraction.measureTemparature();
    }
}
