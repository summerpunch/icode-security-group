package com.icode.security.cas.core.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import com.icode.security.cas.core.properties.SecurityProperties;

/**
 * Title: <br>
 * Description: 让配置读取器 SecurityProperties 生效<br>
 * Author: XiaChong<br>
 * Mail: summerpunch@163.com<br>
 * Date: 2019/6/15 15:17<br>
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

}
