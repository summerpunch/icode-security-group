package com.icode.security.cas.core.social.support;

import org.springframework.social.security.SocialAuthenticationFilter;

/**
 * Title: <br>
 * Description:
 * <p>
 * SocialAuthenticationFilter后处理器，
 * 用于在不同环境下个性化社交登录的配置
 *
 * <br>
 * Author: XiaChong<br>
 * Mail: summerpunch@163.com<br>
 * Date: 2019/6/18 17:55<br>
 */
public interface SocialAuthenticationFilterPostProcessor {

    void process(SocialAuthenticationFilter socialAuthenticationFilter);

}
