package com.icode.security.cas.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icode.security.cas.core.common.constant.Final;
import com.icode.security.cas.core.common.response.SimpleResponse;
import com.icode.security.cas.core.properties.LoginResponseType;
import com.icode.security.cas.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Title: 浏览器环境下登录失败的处理器<br>
 * Description: <br>
 * Author: XiaChong<br>
 * Mail: summerpunch@163.com<br>
 * Date: 2019/5/11 17:20<br>
 */
@Component("icodeAuthenctiationFailureHandler")
public class IcodeAuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private static final Logger LOGGERS = LoggerFactory.getLogger(IcodeAuthenctiationFailureHandler.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        LOGGERS.info("登录失败");

        /**
         * 如果是配置了JSON，则返回JSON信息
         * 否则跳转到错误页面
         */
        if (LoginResponseType.JSON.equals(securityProperties.getBrowser().getLoginResponseType())) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType(Final.CONTENT_TYPE);
            response.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse(exception.getMessage())));
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}
