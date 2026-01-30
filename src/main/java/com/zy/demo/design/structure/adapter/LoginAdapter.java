package com.zy.demo.design.structure.adapter;

/**
 * 登录适配器
 *
 * @author zy
 */
public class LoginAdapter implements Login {

    /**
     * 持有适配对象
     */
    private final QrCodeLogin qrCodeLogin;

    /**
     * 适配器绑定适配目标
     *
     * @param qrCodeLogin 二维码登录
     */
    public LoginAdapter(QrCodeLogin qrCodeLogin) {
        this.qrCodeLogin = qrCodeLogin;
    }

    @Override
    public void logon() {
        //登录适配二维码
        this.qrCodeLogin.qrCodeLogon();
    }

    @Override
    public void logout() {
        //登出适配二维码
        this.qrCodeLogin.qrCodeLogout();
    }

    @Override
    public void keepalive() {
        //保持会话适配二维码
        this.qrCodeLogin.qrCodeKeepalive();
    }
}
