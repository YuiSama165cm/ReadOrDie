package com.yui.rod.tranfic.strategy;

public class BusStrategy implements CalculateStrategy{
    @Override
    public int calculatePrice(int km) {
        return km*2;
    }
}
