package com.icode.security.cas.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icode.security.cas.core.common.constant.Final;
import com.icode.security.cas.core.common.response.SimpleResponse;
import com.icode.security.cas.core.properties.LoginResponseType;
import com.icode.security.cas.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Title: 浏览器环境下登录成功的处理器<br>
 * Description: <br>
 * Author: XiaChong<br>
 * Mail: summerpunch@163.com<br>
 * Date: 2019/5/11 17:20<br>
 */
@Component("icodeAuthenticationSuccessHandler")
public class IcodeAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private static final Logger LOGGERS = LoggerFactory.getLogger(IcodeAuthenticationSuccessHandler.class);

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private SecurityProperties securityProperties;

	private RequestCache requestCache = new HttpSessionRequestCache();


	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

		LOGGERS.info("登录成功");


		if (LoginResponseType.JSON.equals(securityProperties.getBrowser().getLoginResponseType())) {
			response.setContentType(Final.CONTENT_TYPE);
			String type = authentication.getClass().getSimpleName();
			response.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse(type)));
		} else {

			/**
			 * 如果设置了 icode.security.cas.browser.singInSuccessUrl，总是跳到设置的地址上
			 * 如果没设置，则尝试跳转到登录之前访问的地址上，如果登录前访问地址为空，则跳到网站根路径上
			 */
			/*if (StringUtils.isNotBlank(securityProperties.getBrowser().getSingInSuccessUrl())) {
				requestCache.removeRequest(request, response);
				setAlwaysUseDefaultTargetUrl(true);
				setDefaultTargetUrl(securityProperties.getBrowser().getSingInSuccessUrl());
			}*/
			super.onAuthenticationSuccess(request, response, authentication);
		}

	}

}
