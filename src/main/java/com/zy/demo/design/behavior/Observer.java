package com.zy.demo.design.behavior;

/**
 * 观察者
 *
 * @author zy
 */
public interface Observer {

    /**
     * 消息通信
     *
     * @param msg 消息
     */
    void message(String msg);
}
