package com.zy.demo.design.structure.adapter;

/**
 * 类适配器模式
 * 单继承，不灵活
 *
 * @author zy
 */
public class ClassAdapterMode extends QrCodeLogin implements Login {

    @Override
    public void logon() {
        super.qrCodeLogon();
    }

    @Override
    public void logout() {
        super.qrCodeLogout();
    }

    @Override
    public void keepalive() {
        super.qrCodeKeepalive();
    }

    public static void main(String[] args) {
        //适配器已经内部绑定适配者
        ClassAdapterMode adapter = new ClassAdapterMode();
        //直接调用适配方法
        adapter.logout();
    }
}
