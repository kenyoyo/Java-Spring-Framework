package com.kazdo.bank_app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kazdo.bank_app.AppConfig;
import com.kazdo.bank_app.Security;

public class SecurityTest {

	private ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	private Security secure;

	@Before
	public void setup() {
		secure = context.getBean(Security.class);
	}

	@Test
	public void testHasNotIdentify() {
		assertFalse(secure.isLogin());
	}
	
	@Test
	public void testHasIdentify() {
		secure.identify();
		assertTrue(secure.isLogin());
	}

}
