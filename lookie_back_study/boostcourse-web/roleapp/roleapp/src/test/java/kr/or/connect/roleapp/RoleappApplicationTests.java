package kr.or.connect.roleapp;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class RoleappApplicationTests {
	@Autowired
	DataSource ds;
	@Test
	public void connectionTest() throws Exception{
		Connection conn = ds.getConnection();
		
		Assert.assertNotNull(conn);
		if(conn != null) {
			System.out.println("conn ok!");
		}
	}

	@Test
	void contextLoads() {
	}

}
