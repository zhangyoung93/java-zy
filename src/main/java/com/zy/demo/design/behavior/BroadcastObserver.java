package com.zy.demo.design.behavior;

/**
 * 广播观察者
 *
 * @author zy
 */
public class BroadcastObserver implements Observer {

    @Override
    public void message(String msg) {
        System.out.println("BroadcastObserver receive msg:" + msg);
    }
}
