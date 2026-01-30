package com.zy.demo.design.behavior.chain;

/**
 * 请假工单
 *
 * @author zy
 */
public class ApplyForLeaveOrder {

    /**
     * 工单ID
     */
    private final Long orderId;

    /**
     * 申请人
     */
    private final String applicant;

    /**
     * 请假天数
     */
    private final int leaveDays;

    /**
     * 构建请假工单
     *
     * @param orderId   orderId
     * @param applicant applicant
     * @param leaveDays leaveDays
     */
    public ApplyForLeaveOrder(Long orderId, String applicant, int leaveDays) {
        this.orderId = orderId;
        this.applicant = applicant;
        this.leaveDays = leaveDays;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getApplicant() {
        return applicant;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    @Override
    public String toString() {
        return "ApplyForLeaveOrder{" +
                "orderId=" + orderId +
                ", applicant='" + applicant + '\'' +
                ", leaveDays=" + leaveDays +
                '}';
    }
}
