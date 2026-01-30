package com.zy.demo.design.behavior.chain;

/**
 * 部门经理审批人
 *
 * @author zy
 */
public class DepartmentManagerApprover extends AbstractApprover {

    @Override
    void approve(ApplyForLeaveOrder applyForLeaveOrder) {
        //请假天数大于7天则将工单交给下一个审批人
        if (applyForLeaveOrder.getLeaveDays() > 7) {
            super.nextApprover.approve(applyForLeaveOrder);
        } else {
            System.out.println("DepartmentManagerApprover has approved");
        }
    }
}
