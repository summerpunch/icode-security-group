package com.icode.security.cas.core.social.weixin.api;

/**
 * Title: 微信API调用接口<br>
 * Description: <br>
 * Author: XiaChong<br>
 * Mail: summerpunch@163.com<br>
 * Date: 2019/6/18 18:31<br>
 */
public interface Weixin {
    WeixinUserInfo getUserInfo(String openId);

}
