package com.zy.demo.design.behavior.strategy;

/**
 * 内存清理策略
 *
 * @author zy
 */
public interface RamCleanStrategy {

    /**
     * 内存清理
     */
    void ramClean();
}
