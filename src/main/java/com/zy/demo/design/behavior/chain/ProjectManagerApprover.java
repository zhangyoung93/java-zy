package com.zy.demo.design.behavior.chain;

/**
 * 项目经理审批人
 *
 * @author zy
 */
public class ProjectManagerApprover extends AbstractApprover {

    @Override
    void approve(ApplyForLeaveOrder applyForLeaveOrder) {
        if (applyForLeaveOrder == null) {
            throw new IllegalArgumentException("applyForLeaveOrder must not be null");
        }
        //请假天数大于3天则将工单交给下一个审批人
        if (applyForLeaveOrder.getLeaveDays() > 3) {
            super.nextApprover.approve(applyForLeaveOrder);
        } else {
            System.out.println("ProjectManagerApprover has approved");
        }
    }
}
