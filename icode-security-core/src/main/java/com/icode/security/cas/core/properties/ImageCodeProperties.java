package com.icode.security.cas.core.properties;

/**
 * Title: 图形验证码配置相关<br>
 * Description: <br>
 * Author: XiaChong<br>
 * Mail: summerpunch@163.com<br>
 * Date: 2019/6/15 17:42<br>
 */
public class ImageCodeProperties extends SmsCodeProperties {

    private Integer width = 67;
    private Integer height = 23;

    public ImageCodeProperties() {
        setLength(4);
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
