package com.icode.security.cas.core.social.weixin.connect;

import org.springframework.social.oauth2.AccessGrant;

/**
 * Title: <br>
 * Description:
 * 微信的access_token信息。与标准OAuth2协议不同，
 * 微信在获取access_token时会同时返回openId,
 * 并没有单独的通过accessToke换取openId的服务
 * <p>
 * 所以在这里继承了标准AccessGrant，添加了openId字段，
 * 作为对微信access_token信息的封装。
 * <br>
 * Author: XiaChong<br>
 * Mail: summerpunch@163.com<br>
 * Date: 2019/6/18 19:49<br>
 */
public class WeixinAccessGrant extends AccessGrant {

    private static final long serialVersionUID = -7243374334633182782L;

    private String openId;

    public WeixinAccessGrant() {
        super("");
    }

    public WeixinAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn) {
        super(accessToken, scope, refreshToken, expiresIn);
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

}
