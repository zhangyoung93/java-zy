package com.zy.demo.design.behavior.chain;

/**
 * 抽象审批者
 *
 * @author zy
 */
public abstract class AbstractApprover {

    protected AbstractApprover nextApprover;

    public void setNextApprover(AbstractApprover nextApprover) {
        this.nextApprover = nextApprover;
    }

    /**
     * 审批
     *
     * @param applyForLeaveOrder 请假工单
     */
    abstract void approve(ApplyForLeaveOrder applyForLeaveOrder);
}
