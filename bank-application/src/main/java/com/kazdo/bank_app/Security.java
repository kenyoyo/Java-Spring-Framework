package com.kazdo.bank_app;

import org.springframework.stereotype.Component;

@Component
public class Security {

	private boolean isLogin;

	public void identify() {
		isLogin = true;
	}

	public boolean isLogin() {
		return isLogin;
	}

}
