package com.powernode.proxy.client;

import com.powernode.proxy.service.TimeMethodInterceptor;
import com.powernode.proxy.service.UserService;
import net.sf.cglib.proxy.Enhancer;

public class Client {
    public static void main(String[] args) {
        // 创建字节码增强器
        Enhancer enhancer = new Enhancer();
        // 告诉cglib要继承哪个类
        enhancer.setSuperclass(UserService.class);
        // 设置回调接口相当于InvocationHandler
        enhancer.setCallback(new TimeMethodInterceptor());
        // 生成源码，编译class，加载到JVM，并创建代理对象
        UserService userServiceProxy  = (UserService) enhancer.create();
        //调用代理对象的代理方法
        boolean success = userServiceProxy.login("admin","123");
        System.out.println(success?"登录成功":"登录失败");

        userServiceProxy.logout();


    }
}
