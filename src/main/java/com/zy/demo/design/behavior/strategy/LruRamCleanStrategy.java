package com.zy.demo.design.behavior.strategy;

/**
 * LRU内存清理策略
 *
 * @author zy
 */
public class LruRamCleanStrategy implements RamCleanStrategy {

    @Override
    public void ramClean() {
        System.out.println("LruRamCleanStrategy");
    }
}
