package com.yui.rod;

import com.yui.rod.member.factory.DeleteMemberFactory;
import com.yui.rod.member.factory.MemberFactory;
import com.yui.rod.member.factory.ReadMemberFactory;
import com.yui.rod.member.function.DeleteFunction;
import com.yui.rod.member.function.ReadFunction;
import com.yui.rod.member.function.SpeakFunction;
import com.yui.rod.member.function.WriteFunction;
import com.yui.rod.tranfic.CalculateUtils;
import com.yui.rod.tranfic.strategy.BusStrategy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        CalculateUtils calculateUtils = new CalculateUtils();
        calculateUtils.setStrategy(new BusStrategy());
        System.out.println("价格为"+calculateUtils.calculatePrice(16));
    }

    private void getFunction(MemberFactory memberFactory) {
        DeleteFunction deleteFunction = memberFactory.delete();
        deleteFunction.delete();
        ReadFunction readFunction = memberFactory.read();
        readFunction.read();
        WriteFunction writeFunction = memberFactory.write();
        writeFunction.write();
        SpeakFunction speakFunction = memberFactory.speak();
        speakFunction.speak();
    }
}