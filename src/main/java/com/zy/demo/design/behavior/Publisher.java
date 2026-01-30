package com.zy.demo.design.behavior;

/**
 * 消息发布者
 *
 * @author zy
 */
public interface Publisher {

    /**
     * 添加观察者
     *
     * @param observer observer
     */
    void addObserver(Observer observer);

    /**
     * 移除观察者
     *
     * @param observer observer
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     *
     * @param message 通知消息
     */
    void notifyObserver(String message);
}
