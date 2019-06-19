package com.icode.security.cas.config.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;


/**
 * Title: 处理用户校验逻辑<br>
 * Description: <br>
 * Author: XiaChong<br>
 * Mail: summerpunch@163.com<br>
 * Date: 2019/6/18 16:05<br>
 */
@Component
public class MyUserTest implements UserDetailsService, SocialUserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyUserTest.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("username是:" + username);
        return buildUser(username);
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        LOGGER.info("userId是:" + userId);
        return buildUser(userId);
    }

    private SocialUserDetails buildUser(String userId) {

        //查找数据库返回账户信息
        return new SocialUser(userId,
                passwordEncoder.encode("123456"),
                //账户是否可用：true(没有) / false(是)
                true,
                //账户是否过期：true(没有) / false(是)
                true,
                //密码是否过期：true(没有) / false(是)
                true,
                //账户是否被锁定：true(没有) / false(是)
                true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
