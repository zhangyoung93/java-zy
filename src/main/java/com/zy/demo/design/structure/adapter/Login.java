package com.zy.demo.design.structure.adapter;

/**
 * 对外暴露的登录接口
 *
 * @author zy
 */
public interface Login {

    /**
     * 登录
     */
    void logon();

    /**
     * 登出
     */
    void logout();

    /**
     * 保持会话
     */
    void keepalive();
}
