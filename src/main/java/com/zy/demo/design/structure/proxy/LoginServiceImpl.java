package com.zy.demo.design.structure.proxy;

/**
 * LoginServiceImpl
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
