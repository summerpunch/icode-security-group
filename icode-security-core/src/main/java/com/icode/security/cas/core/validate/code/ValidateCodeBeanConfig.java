package com.icode.security.cas.core.validate.code;

import com.icode.security.cas.core.properties.SecurityProperties;
import com.icode.security.cas.core.validate.code.image.ImageCodeGenerator;
import com.icode.security.cas.core.validate.code.sms.DefaultSmsCodeSender;
import com.icode.security.cas.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Title: 接口逻辑可配置<br>
 * Description:
 *
 * 可用户自定义配置实现覆盖默认
 *
 * <br>
 * Author: XiaChong<br>
 * Mail: summerpunch@163.com<br>
 * Date: 2019/6/15 18:21<br>
 */
@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * Title: 根据用户配置动态实例化实现逻辑<br>
     * Description:
     * <p>
     * 如果其余依赖项目没有另外扩展图片验证码逻辑
     * <p>
     * imageValidateCodeGenerator
     * <p>
     * 则会调用默认图片验证码逻辑
     *
     * <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2019/6/15 18:28<br>
     * Param: <br>
     * Return:
     */
    @Bean
    //@ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
    @ConditionalOnMissingBean(ValidateCodeGenerator.class)
    public ValidateCodeGenerator imageValidateCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

    /**
     * Title: 根据用户配置动态实例化实现逻辑<br>
     * Description:
     * <p>
     * 如果其余依赖项目没有另外扩展短信验证码逻辑
     * <p>
     * smsCodeSender
     * <p>
     * 则会调用默认短信验证码逻辑
     *
     * <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2019/6/15 18:28<br>
     * Param: <br>
     * Return:
     */
    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }

}
