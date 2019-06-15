package com.icode.security.cas.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * Title: 异常信息<br>
 * Description: <br>
 * Author: XiaChong<br>
 * Mail: summerpunch@163.com<br>
 * Date: 2019/6/15 17:18<br>
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = -728523345695468156L;

    public ValidateCodeException(String msg) {
        super(msg);
    }

}
