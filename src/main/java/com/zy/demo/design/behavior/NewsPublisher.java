package com.zy.demo.design.behavior;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * 新闻发布者
 *
 * @author zy
 */
public class NewsPublisher implements Publisher {

    /**
     * 观察者集合
     */
    private final Set<Observer> observerSet = new HashSet<>();

    @Override
    public void addObserver(Observer observer) {
        Optional.ofNullable(observer).ifPresent(observerSet::add);
    }

    @Override
    public void removeObserver(Observer observer) {
        Optional.ofNullable(observer).ifPresent(observerSet::remove);
    }

    @Override
    public void notifyObserver(String message) {
        for (Observer observer : observerSet) {
            observer.message(message);
        }
    }

    public static void main(String[] args) {
        //创建发布者
        Publisher publisher = new NewsPublisher();
        //创建观察者
        Observer broadcastObserver = new BroadcastObserver();
        Observer televisionObserver = new TelevisionObserver();
        //发布者内注册观察者
        publisher.addObserver(broadcastObserver);
        publisher.addObserver(televisionObserver);
        //发布通知
        publisher.notifyObserver("hello");
    }
}
