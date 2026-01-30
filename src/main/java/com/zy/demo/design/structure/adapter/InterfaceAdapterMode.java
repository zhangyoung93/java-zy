package com.zy.demo.design.structure.adapter;

/**
 * 接口适配器模式
 *
 * @author zy
 */
public class InterfaceAdapterMode extends InterfaceAdapter {

    @Override
    public void logon() {
        System.out.println("InterfaceAdapter logon");
    }

    @Override
    public void logout() {
        System.out.println("InterfaceAdapter logout");
    }

    public static void main(String[] args) {
        InterfaceAdapterMode adapter = new InterfaceAdapterMode();
        adapter.logon();
    }
}
