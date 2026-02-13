package com.zy.demo.design.structure.adapter;

/**
 * 二维码登录，不兼容登录接口
 *
 * @author zy
 */
public class QrCodeLogin {

    public void qrCodeLogon() {
        System.out.println("QrCodeLogin logon");
    }

    public void qrCodeLogout() {
        System.out.println("QrCodeLogin logout");
    }

    public void qrCodeKeepalive() {
        System.out.println("QrCodeLogin keepalive");
    }
}
