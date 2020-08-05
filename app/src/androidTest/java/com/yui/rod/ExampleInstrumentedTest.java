package com.yui.rod;

import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import com.yui.rod.tranfic.CalculateUtils;
import com.yui.rod.tranfic.strategy.BusStrategy;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        CalculateUtils calculateUtils = new CalculateUtils();
        calculateUtils.setStrategy(new BusStrategy());
        System.out.println("价格为"+calculateUtils.calculatePrice(16));
    }
}
