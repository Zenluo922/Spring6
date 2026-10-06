package com.powernode.reflet;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //用反射
        //1.获取类
        Class<?> clazz = Class.forName("com.powernode.reflet.SomeService");
        //2.获取方法
        Method doSome = clazz.getDeclaredMethod("doSome",String.class,int.class);
        //3.调用这个方法,四要素：调用哪个对象、哪个方法、传什么参数、返回什么值。
        Object o = clazz.newInstance();//用无参构造创建对象
        Object obj = doSome.invoke(o, "张无忌", 19);//调用这个方法，调用前需要new对象
        System.out.println(obj);
    }
}
