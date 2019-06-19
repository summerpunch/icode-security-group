package com.icode.security.cas.core.authentication;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUserDetailsService;

/**
 * Title: <br>
 * Description:
 * 认证相关的扩展点配置。配置在这里的bean，
 * 业务系统都可以通过声明同类型或同名的bean来覆盖安全
 * 模块默认的配置。
 * <br>
 * Author: XiaChong<br>
 * Mail: summerpunch@163.com<br>
 * Date: 2019/6/17 20:24<br>
 */
@Configuration
public class AuthenticationBeanConfig {

	/**
	 * Title: 默认密码处理器<br>
	 * Description: <br>
	 * Author: XiaChong<br>
	 * Mail: summerpunch@163.com<br>
	 * Date: 2019/6/17 20:24<br>
	 */
	@Bean
	@ConditionalOnMissingBean(PasswordEncoder.class)
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * Title: 默认认证器<br>
	 * Description: <br>
	 * Author: XiaChong<br>
	 * Mail: summerpunch@163.com<br>
	 * Date: 2019/6/17 20:23<br>
	 * Param: <br>
	 * Return:
	 */
	@Bean
	@ConditionalOnMissingBean(UserDetailsService.class)
	public UserDetailsService userDetailsService() {
		return new DefaultUserDetailsService();
	}

	/**
	 * Title: 默认认证器<br>
	 * Description: <br>
	 * Author: XiaChong<br>
	 * Mail: summerpunch@163.com<br>
	 * Date: 2019/6/17 20:23<br>
	 * Param: <br>
	 * Return:
	 */
	@Bean
	@ConditionalOnMissingBean(SocialUserDetailsService.class)
	public SocialUserDetailsService socialUserDetailsService() {
		return new DefaultSocialUserDetailsService();
	}
	
}
