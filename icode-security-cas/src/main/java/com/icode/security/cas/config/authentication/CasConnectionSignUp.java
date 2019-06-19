package com.icode.security.cas.config.authentication;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

@Component
public class CasConnectionSignUp implements ConnectionSignUp {

    @Override
    public String execute(Connection<?> connection) {
        //配置之后，根据社交用户信息默认创建用户并返回用户唯一标识
        return connection.getDisplayName();
    }

}
