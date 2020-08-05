package com.yui.rod.member.function;

public interface ReadFunction {
    void read();
}

class UnRead implements ReadFunction{
    @Override
    public void read() {
        System.out.println("无读取权限");
    }
}

class OnRead implements ReadFunction{
    @Override
    public void read() {
        System.out.println("有读取权限");
    }
}
