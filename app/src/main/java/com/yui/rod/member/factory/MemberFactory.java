package com.yui.rod.member.factory;

import com.yui.rod.member.function.DeleteFunction;
import com.yui.rod.member.function.ReadFunction;
import com.yui.rod.member.function.SpeakFunction;
import com.yui.rod.member.function.WriteFunction;

public interface MemberFactory {
    DeleteFunction delete();
    ReadFunction read();
    SpeakFunction speak();
    WriteFunction write();
}
