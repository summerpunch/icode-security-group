package com.icode.security.cas.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class MyUserTest implements UserDetailsService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Title: <br>
     * Description: 处理用户校验逻辑<br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2019/6/15 14:42<br>
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println(username);
        //查找数据库返回账户信息
        return new User(username,
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
