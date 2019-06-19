package com.icode.security.cas.browser.config;

import com.icode.security.cas.core.authentication.FormAuthenticationConfig;
import com.icode.security.cas.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.icode.security.cas.core.properties.SecurityConstants;
import com.icode.security.cas.core.properties.SecurityProperties;
import com.icode.security.cas.core.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationSuccessHandler icodeAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler icodeAuthenctiationFailureHandler;

    @Autowired
    private FormAuthenticationConfig formAuthenticationConfig;


    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Autowired
    private SpringSocialConfigurer icodeSocialSecurityConfig;

    @Autowired
    private InvalidSessionStrategy invalidSessionStrategy;

    @Autowired
    private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

    /**
     * Title: 处理密码加密解密<br>
     * Description: <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2019/6/15 14:43<br>
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("123456");
        formAuthenticationConfig.configure(http);
        //开启表单登陆
        http
                //自定义表单登陆
               /* .formLogin()
                    //跳转到默认登录页
                    .loginPage("/authentication/require")
                    //用这个请求去处理用户登陆
                    .loginProcessingUrl("/authentication/form")
                    //使用自定义成功处理器
                    .successHandler(icodeAuthenticationSuccessHandler)
                    //使用自定义失败处理器
                    .failureHandler(icodeAuthenctiationFailureHandler)*/

                .apply(validateCodeSecurityConfig)
                .and()
                .apply(smsCodeAuthenticationSecurityConfig)
                .and()
                .apply(icodeSocialSecurityConfig)

                //记住我 .start
                .and()
                .rememberMe()
                    .tokenRepository(persistentTokenRepository())
                    //配置过期秒数
                    .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                    //用这个去做登陆
                    .userDetailsService(userDetailsService)
                //记住我 .end
                .and()

                //session管理 .start
                .sessionManagement()
                    .invalidSessionStrategy(invalidSessionStrategy)
                    .maximumSessions(securityProperties.getBrowser().getSession().getMaximumSessions())
                    .maxSessionsPreventsLogin(securityProperties.getBrowser().getSession().isMaxSessionsPreventsLogin())
                    .expiredSessionStrategy(sessionInformationExpiredStrategy)
                .and()
                //session管理 .end

                .and()
                //退出 .start
                .logout()
                .logoutUrl("/signOut")
                .logoutSuccessHandler(logoutSuccessHandler)
                .deleteCookies("JSESSIONID")
                //退出 .end

                .and()
                //对请求作授权 .start
                .authorizeRequests()
                //对指定路径放行
                .antMatchers(
                        SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                        securityProperties.getBrowser().getLoginPage(),
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*",
                        securityProperties.getBrowser().getSignUpUrl()
                      //  securityProperties.getBrowser().getSession().getSessionInvalidUrl()+Final.JSON,
                      //  securityProperties.getBrowser().getSession().getSessionInvalidUrl()+ Final.HTML,
                       // "/user/regist"
                )
                .permitAll()
                //任何请求
                .anyRequest()
                //都需要身份认证
                .authenticated()
                //对请求作授权 .start
                //关闭跨站请求伪造
                .and().csrf().disable()
        ;
    }

    /**
     * Title: 记住我功能<br>
     * Description: <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2019/6/17 10:36<br>
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        /**
         * 是否自动创建表
         * 创建的表名为：persistent_logins
         * 已创建则消除下面代码
         */
        //tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }
}
