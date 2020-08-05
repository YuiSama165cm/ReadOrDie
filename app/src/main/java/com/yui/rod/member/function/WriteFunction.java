package com.yui.rod.member.function;

public interface WriteFunction {
    void write();
}

class UnWrite implements WriteFunction{
    @Override
    public void write() {
        System.out.println("无写权限");
    }
}

class OnWrite implements WriteFunction{
    @Override
    public void write() {
        System.out.println("有写权限");
    }
}
