package com.icode.security.cas.core.social;

import com.icode.security.cas.core.social.support.SocialUserInfo;
import org.springframework.social.connect.Connection;

public abstract class SocialController {

    /**
     * Title: 根据Connection信息构建SocialUserInfo<br>
     * Description: <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2019/6/18 17:58<br>
     */
    protected SocialUserInfo buildSocialUserInfo(Connection<?> connection) {
        SocialUserInfo userInfo = new SocialUserInfo();
        userInfo.setProviderUserId(connection.getKey().getProviderUserId());
        userInfo.setProviderId(connection.getKey().getProviderId());
        userInfo.setNickname(connection.getDisplayName());
        userInfo.setHeadimg(connection.getImageUrl());
        return userInfo;
    }

}
