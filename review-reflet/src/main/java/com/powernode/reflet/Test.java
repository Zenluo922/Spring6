package com.powernode.reflet;

public class Test {
    public static void main(String[] args) {
        //不用反射
        SomeService someService = new SomeService();
        someService.doSome();
        String s1 = someService.doSome("张无忌");
        String s2 = someService.doSome("张无忌",19);
        System.out.println(s1);
        System.out.println(s2);
    }
}
