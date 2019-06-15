package com.icode.security.cas.browser.config;

import com.icode.security.cas.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler icodeAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler icodeAuthenctiationFailureHandler;

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
        //开启表单登陆
            http.formLogin()
                //跳转到默认登录页
                .loginPage("/authentication/require")
                //用这个请求去处理用户登陆
                .loginProcessingUrl("/authentication/form")
                //使用自定义成功处理器
                .successHandler(icodeAuthenticationSuccessHandler)
                //使用自定义失败处理器
                .failureHandler(icodeAuthenctiationFailureHandler)
                .and()
                //对请求作授权
                .authorizeRequests()
                //对指定路径放行
                .antMatchers("/authentication/require",securityProperties.getBrowser().getLoginPage()).permitAll()
                //任何请求
                .anyRequest()
                //都需要身份认证
                .authenticated()
                //关闭跨站请求伪造
                .and().csrf().disable()
        ;
    }
    /**
     * Title: 配置允许放行的路径<br>
     * Description: <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2019/6/15 15:26<br>
     */
    /*private String permitThrough(){
        StringBuilder sb = new StringBuilder();
        sb.append("/authentication/require");
        sb.append(securityProperties.getBrowser().getLoginPage());
        System.out.println(sb.toString());
        return sb.toString();
    }*/
}
