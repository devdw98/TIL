package dw.study.lookie.pr_naver_reservation_api.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dw.study.lookie.pr_naver_reservation_api.config.ApplicationConfig;
import dw.study.lookie.pr_naver_reservation_api.config.SecurityConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {ApplicationConfig.class, SecurityConfig.class})
public class PasswordEncoderTest {
	@Autowired
	PasswordEncoder encoder;
	
	@Test
	public void passwordEncode()throws Exception{
		System.out.println(encoder.encode("1234"));
	}
	
	@Test
	public void passwordTest()throws Exception{
    	String encodePasswd = "$2a$10$USbExG2YOZJqu5rR9eWAqO3NqwjS6c8uI0c695cnURA2gxqRnx41O";
    	String password = "1234";
    	boolean test = encoder.matches(password, encodePasswd);
    	System.out.println(test);
	}
}
