package com.yui.rod.member.factory;

import com.yui.rod.member.function.DeleteFunction;
import com.yui.rod.member.function.DeleteLevel;
import com.yui.rod.member.function.ReadFunction;
import com.yui.rod.member.function.ReadLevel;
import com.yui.rod.member.function.SpeakFunction;
import com.yui.rod.member.function.SpeakLevel;
import com.yui.rod.member.function.WriteFunction;
import com.yui.rod.member.function.WriteLevel;

public class DeleteMemberFactory implements MemberFactory {
    @Override
    public DeleteFunction delete() {
        return new DeleteLevel().OnDelete();
    }

    @Override
    public ReadFunction read() {
        return new ReadLevel().UnRead();
    }

    @Override
    public SpeakFunction speak() {
        return new SpeakLevel().UnSpeak();
    }

    @Override
    public WriteFunction write() {
        return new WriteLevel().UnWrite();
    }
}
