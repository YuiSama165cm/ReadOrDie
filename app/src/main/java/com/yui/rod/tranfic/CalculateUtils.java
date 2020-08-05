package com.yui.rod.tranfic;

import com.yui.rod.tranfic.strategy.CalculateStrategy;

public class CalculateUtils {
    CalculateStrategy mCalculateStrategy;
    public void setStrategy(CalculateStrategy mCalculateStrategy){
        this.mCalculateStrategy = mCalculateStrategy;
    }
    public int calculatePrice(int km){
        return mCalculateStrategy.calculatePrice(km);
    }
}
