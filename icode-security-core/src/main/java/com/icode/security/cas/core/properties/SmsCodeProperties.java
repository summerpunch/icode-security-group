package com.icode.security.cas.core.properties;

/**
 * Title: 短信配置相关<br>
 * Description: <br>
 * Author: XiaChong<br>
 * Mail: summerpunch@163.com<br>
 * Date: 2019/6/15 17:43<br>
 * Param: <br>
 * Return:
 */
public class SmsCodeProperties {

    private Integer length = 6;
    private Integer expireIn = 60;
    private String url;

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(Integer expireIn) {
        this.expireIn = expireIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
