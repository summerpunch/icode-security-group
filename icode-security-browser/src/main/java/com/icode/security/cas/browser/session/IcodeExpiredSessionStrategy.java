package com.icode.security.cas.browser.session;

import com.icode.security.cas.core.properties.SecurityProperties;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Title: 并发登录导致session失效时，默认的处理策略<br>
 * Description: <br>
 * Author: XiaChong<br>
 * Mail: summerpunch@163.com<br>
 * Date: 2019/6/19 10:48<br>
 */
public class IcodeExpiredSessionStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {

	public IcodeExpiredSessionStrategy(SecurityProperties securityPropertie) {
		super(securityPropertie);
	}

	@Override
	public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
		onSessionInvalid(event.getRequest(), event.getResponse());
	}
	
	@Override
	protected boolean isConcurrency() {
		return true;
	}

}
