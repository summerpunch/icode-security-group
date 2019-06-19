package com.icode.security.cas.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

public class WeixinProperties extends SocialProperties {

    /**
     * 第三方id，用来决定发起第三方登录的url，默认是 weixin
     */
    private String providerId = "weixin";

    /**
     * providerId
     */
    public String getProviderId() {
        return providerId;
    }

    /**
     * the providerId to set
     */
    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }


}
