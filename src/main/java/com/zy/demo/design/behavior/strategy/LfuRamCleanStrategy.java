package com.zy.demo.design.behavior.strategy;

/**
 * LFU内存清理策略
 *
 * @author zy
 */
public class LfuRamCleanStrategy implements RamCleanStrategy {

    @Override
    public void ramClean() {
        System.out.println("LfuRamCleanStrategy");
    }
}
