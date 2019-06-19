package com.icode.security.cas.core.social.qq.connet;

import com.icode.security.cas.core.social.qq.api.QQ;
import com.icode.security.cas.core.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;


public class QQAdapter implements ApiAdapter<QQ> {

	@Override
	public boolean test(QQ api) {
		return true;
	}

	@Override
	public void setConnectionValues(QQ api, ConnectionValues values) {
		QQUserInfo userInfo = api.getUserInfo();
		values.setDisplayName(userInfo.getNickname());
		values.setProviderUserId(userInfo.getOpenId());
		values.setImageUrl(userInfo.getFigureurl_qq_1());
		//QQ没有主页，设置为null
		values.setProfileUrl(null);
	}

	/**
	 * Title: 绑定解绑<br>
	 * Description: <br>
	 * Author: XiaChong<br>
	 * Mail: summerpunch@163.com<br>
	 * Date: 2019/6/18 15:30<br>
	 */
	@Override
	public UserProfile fetchUserProfile(QQ api) {
		return null;
	}

	@Override
	public void updateStatus(QQ api, String message) {
	}

}
