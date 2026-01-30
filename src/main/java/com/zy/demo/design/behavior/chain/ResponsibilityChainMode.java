package com.zy.demo.design.behavior.chain;

/**
 * 责任链模式
 *
 * @author zy
 */
public class ResponsibilityChainMode {

    public static void main(String[] args) {
        //创建请求工单
        ApplyForLeaveOrder order = new ApplyForLeaveOrder(1L, "Tom", 8);
        //创建审批人角色
        AbstractApprover projectManagerApprover = new ProjectManagerApprover();
        AbstractApprover departmentManagerApprover = new DepartmentManagerApprover();
        AbstractApprover generalManagerApprover = new GeneralManagerApprover();
        //设置责任链
        projectManagerApprover.setNextApprover(departmentManagerApprover);
        departmentManagerApprover.setNextApprover(generalManagerApprover);
        //从项目经理开始审批
        projectManagerApprover.approve(order);
    }
}
