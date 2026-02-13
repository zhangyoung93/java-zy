package com.zy.demo.design.behavior.chain;

/**
 * 总经理审批人
 *
 * @author zy
 */
public class GeneralManagerApprover extends AbstractApprover {

    @Override
    void approve(ApplyForLeaveOrder applyForLeaveOrder) {
        System.out.println("GeneralManagerApprover has approved");
    }
}
