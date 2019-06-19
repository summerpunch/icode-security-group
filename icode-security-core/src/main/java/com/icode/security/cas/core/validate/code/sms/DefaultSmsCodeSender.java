package com.icode.security.cas.core.validate.code.sms;

public class DefaultSmsCodeSender implements SmsCodeSender {

    /**
     * Title: 短信登陆<br>
     * Description: 需要配置短信提供服务商<br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2019/6/17 11:08<br>
     */
    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机" + mobile + "发送短信验证码" + code);
    }

}
