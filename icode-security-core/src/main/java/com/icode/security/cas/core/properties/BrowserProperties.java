package com.icode.security.cas.core.properties;

/**
 * 浏览器环境配置项
 */
public class BrowserProperties {

    /**
     * 用户没有配置的情况下：默认登录页
     * 用户自定义配置方式：icode.security.cas.browser.loginPage = /demo-signIn.html
     */
    private String loginPage = "/icode-signIn.html";


    /**
     * 用户没有配置的情况下：默认登录响应的方式是json
     */
    private LoginResponseType loginResponseType = LoginResponseType.JSON;

    /**
     * 登录成功后跳转的地址，如果设置了此属性，则登录成功后总是会跳到这个地址上
     * 只在 loginResponseType 为REDIRECT时生效
     */
   // private String singInSuccessUrl;


    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginResponseType getLoginResponseType() {
        return loginResponseType;
    }

    public void setLoginResponseType(LoginResponseType loginResponseType) {
        this.loginResponseType = loginResponseType;
    }
}
