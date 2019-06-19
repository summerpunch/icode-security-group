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
     * 社交登录，如果需要用户注册，跳转的页面
     */
    private String signUpUrl = "/icode-signUp.html";

    /**
     * 登录页面，当引发登录行为的url以html结尾时，
     * 会跳到这里配置的url上
     */
    private String signInPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;

    /**
     * 退出成功时跳转的url，如果配置了，则跳到指定的url，如果没配置，则返回json数据。
     */
    private String signOutUrl;

    /**
     * 用户没有配置的情况下：默认登录响应的方式是json
     */
    private LoginResponseType loginResponseType = LoginResponseType.JSON;


    /**
     * 记住我.过期时间 1 小时
     */
    private Integer rememberMeSeconds = 3600;

    /**
     * session管理配置项
     */
    private SessionProperties session = new SessionProperties();

    public String getSignInPage() {
        return signInPage;
    }

    public void setSignInPage(String signInPage) {
        this.signInPage = signInPage;
    }

    public String getSignOutUrl() {
        return signOutUrl;
    }

    public void setSignOutUrl(String signOutUrl) {
        this.signOutUrl = signOutUrl;
    }

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

    public Integer getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(Integer rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }

    public String getSignUpUrl() {
        return signUpUrl;
    }

    public void setSignUpUrl(String signUpUrl) {
        this.signUpUrl = signUpUrl;
    }

    public SessionProperties getSession() {
        return session;
    }

    public void setSession(SessionProperties session) {
        this.session = session;
    }
}
