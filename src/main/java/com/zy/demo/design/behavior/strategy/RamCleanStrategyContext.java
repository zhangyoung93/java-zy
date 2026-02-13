package com.zy.demo.design.behavior.strategy;

/**
 * 内存清理策略上下文
 *
 * @author zy
 */
public class RamCleanStrategyContext {

    /**
     * 持有策略引用
     */
    private RamCleanStrategy ramCleanStrategy;

    /**
     * 动态切换策略
     *
     * @param ramCleanStrategy ramCleanStrategy
     */
    public void setRamCleanStrategy(RamCleanStrategy ramCleanStrategy) {
        this.ramCleanStrategy = ramCleanStrategy;
    }

    /**
     * 执行策略
     */
    public void executeStrategy() {
        this.ramCleanStrategy.ramClean();
    }

    public static void main(String[] args) {
        //创建策略上下文对象
        RamCleanStrategyContext context = new RamCleanStrategyContext();
        //选择策略
        context.setRamCleanStrategy(new LfuRamCleanStrategy());
        //执行策略
        context.executeStrategy();
        //切换策略
        context.setRamCleanStrategy(new LruRamCleanStrategy());
        //执行策略
        context.executeStrategy();
    }
}
