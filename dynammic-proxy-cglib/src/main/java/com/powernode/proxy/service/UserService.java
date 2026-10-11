package com.powernode.proxy.service;



public class UserService {

        public boolean login(String username, String password){
            System.out.println("系统正在验证身份");
            if ("admin".equals(username)&&"123".equals(password)){
                return true;
            }
            return false;
        }

        public void logout(){
            System.out.println("用户正在退出系统....");
        }

}
