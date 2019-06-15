package com.icode.security.cas.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * Title: 可配置逻辑<br>
 * Description: <br>
 * Author: XiaChong<br>
 * Mail: summerpunch@163.com<br>
 * Date: 2019/6/15 18:14<br>
 */
public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);

}
