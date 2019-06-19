package com.icode.security.cas.core.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;


/**
 * Title: <br>
 * Description:
 * <p>
 * 默认的SocialUserDetailsService实现
 * 不做任何处理，只在控制台打印一句日志，然后抛出异常，
 * 提醒业务系统自己配置SocialUserDetailsService。
 *
 * <br>
 * Author: XiaChong<br>
 * Mail: summerpunch@163.com<br>
 * Date: 2019/6/17 20:24<br>
 * Param: <br>
 * Return:
 */
public class DefaultSocialUserDetailsService implements SocialUserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        logger.warn("请配置 SocialUserDetailsService 接口的实现.");
        throw new UsernameNotFoundException(userId);
    }

}
