package com.zy.demo.design.structure.adapter;

/**
 * 对象适配器模式
 *
 * @author zy
 */
public class ObjectAdapterMode {

    public static void main(String[] args) {
        //短信登录
        Login login = new SmsLogin();
        login.logon();

        //通过适配器兼容二维码登录
        QrCodeLogin qrCodeLogin = new QrCodeLogin();
        LoginAdapter adapter = new LoginAdapter(qrCodeLogin);
        adapter.logon();
    }
}
