package com.icode.security.cas.core.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Title: <br>
 * Description:
 * 默认的 UserDetailsService 实现
 * 不做任何处理，只在控制台打印一句日志，
 * 然后抛出异常，提醒业务系统自己配置 UserDetailsService。
 * <br>
 * Author: XiaChong<br>
 * Mail: summerpunch@163.com<br>
 * Date: 2019/6/17 20:25<br>
 */
public class DefaultUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.warn("请配置 UserDetailsService 接口的实现.");
        throw new UsernameNotFoundException(username);
    }

}
