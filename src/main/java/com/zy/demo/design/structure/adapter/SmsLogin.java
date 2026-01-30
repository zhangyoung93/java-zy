package com.zy.demo.design.structure.adapter;

/**
 * 短信登录，兼容登录接口
 *
 * @author zy
 */
public class SmsLogin implements Login {

    @Override
    public void logon() {
        System.out.println("SmsLogin logon");
    }

    @Override
    public void logout() {
        System.out.println("SmsLogin logout");
    }

    @Override
    public void keepalive() {
        System.out.println("SmsLogin keepalive");
    }
}
