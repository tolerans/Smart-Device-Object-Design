package com.company;

public class CooolerInteraction {

    private CooolerInteraction whichInteraction;
    
    //Constractor
    public CooolerInteraction(CoolerDriver whichInteraction){
        this.whichInteraction = (CooolerInteraction) whichInteraction;
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
