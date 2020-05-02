package myspring.user.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/data.xml", "classpath:config/aop.xml" })
public class UserClientTest { // JDBC 연결 테스트

	@Autowired
	private ApplicationContext context;

	@Test
	@Ignore
	public void dataSourceTest() {
		DataSource ds = (DataSource) context.getBean("dataSource");

		try {
			System.out.println();
			System.out.println(ds.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Autowired
	UserService service;

	@Test
	public void getUserTest() {
		UserVO user = service.getUser("gd");
		System.out.println(user);
		assertEquals("홍길동", user.getName());
	}

	@Test
	@Ignore
	public void insertUserTest() {
		service.insertUser(new UserVO("dl", "둘리", "M", "Anyang"));
		for (UserVO user : service.getUserList()) {
			System.out.println(user);
		}
	}

	@Test
	@Ignore
	public void updateUserTest() {
		service.updateUser(new UserVO("dl", "둘리", "W", "Busan"));
		UserVO user = service.getUser("dl");
		System.out.println(user);
	}

	@Test
	@Ignore
	public void deleteUserTest() {
		service.deleteUser("dl");
		for (UserVO user : service.getUserList()) {
			System.out.println(user);
		}
	}

}
