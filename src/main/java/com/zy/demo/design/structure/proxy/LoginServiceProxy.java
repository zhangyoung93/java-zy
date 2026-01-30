package com.zy.demo.design.structure.proxy;

/**
 * 代理类
 *
 * @author zy
 */
public class LoginServiceProxy implements LoginService {

    private final LoginService loginService;

    /**
     * 代理类与被代理类绑定
     *
     * @param loginService 被代理类
     */
    public LoginServiceProxy(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * 增强logon方法
     */
    @Override
    public void logon() {
        System.out.println("logon before");
        this.loginService.logon();
        System.out.println("logon after");
    }

    /**
     * 增强logout方法
     */
    @Override
    public void logout() {
        System.out.println("logout before");
        this.loginService.logout();
        System.out.println("logout after");
    }

    public static void main(String[] args) {
        //选择被代理的类
        LoginService loginService = new LoginServiceImpl();
        //绑定代理关系
        LoginServiceProxy proxy = new LoginServiceProxy(loginService);
        //执行代理方法
        proxy.logon();
        proxy.logout();
    }
}
