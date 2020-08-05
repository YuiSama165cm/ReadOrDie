package com.yui.rod.member.function;

public interface SpeakFunction {
    void speak();
}

class UnSpeak implements SpeakFunction{
    @Override
    public void speak() {
        System.out.println("无发言功能");
    }
}

class OnSpeak implements SpeakFunction{
    @Override
    public void speak() {
        System.out.println("有发言功能");
    }
}
