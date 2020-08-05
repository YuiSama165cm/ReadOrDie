package com.yui.rod.member.function;

public interface DeleteFunction {
    void delete();
}

class UnDelete implements DeleteFunction{

    @Override
    public void delete() {
        System.out.println("无删除权限");
    }
}

class OnDelete implements DeleteFunction{
    @Override
    public void delete() {
        System.out.println("有删除权限");
    }
}
