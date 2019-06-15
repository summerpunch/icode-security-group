package com.icode.security.cas.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * Title: 校验码处理器，封装不同校验码的处理逻辑<br>
 * Description: <br>
 * Author: XiaChong<br>
 * Mail: summerpunch@163.com<br>
 * Date: 2019/6/15 17:13<br>
 */
public interface ValidateCodeProcessor {

    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 创建校验码
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 校验验证码
     */
    void validate(ServletWebRequest servletWebRequest);

}
