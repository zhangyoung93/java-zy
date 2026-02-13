package com.zy.demo.design.structure.proxy;

/**
 * 被代理接口实现类
 *
 * @author zy
 */
public class LoginServiceImpl implements LoginService {
    @Override
    public void logon() {
        System.out.println("logon");
    }

    @Override
    public void logout() {
        System.out.println("logout");
    }
}
