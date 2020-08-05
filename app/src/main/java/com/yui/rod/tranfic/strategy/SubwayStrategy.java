package com.yui.rod.tranfic.strategy;

public class SubwayStrategy implements CalculateStrategy{
    @Override
    public int calculatePrice(int km) {
        if(km<=6){
            return 3;
        }else if(km > 6 && km < 12){
            return 4;
        }
        return 7;
    }
}
