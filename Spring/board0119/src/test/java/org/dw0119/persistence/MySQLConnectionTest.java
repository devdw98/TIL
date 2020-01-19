package org.dw0119.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MySQLConnectionTest {

	@Inject
	private DataSource ds;
	
	@Test
	public void testConnection() throws Exception
	{
		try(Connection conn = ds.getConnection()){
			System.out.println("\ncon : "+conn+"\n");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//	private static final String URL = "jdbc:mysql://localhost:3306/ex00?serverTimezone=Asia/Seoul&useSSL=false";
//	//jdbc::mysql:주소:포트/DB명
//	private static final String USER = "user00";
//	private static final String PW = "user00";
//	
//	@Test
//	public void testConnection() throws Exception{
//			Class.forName(DRIVER);
//			try(Connection conn = DriverManager.getConnection(URL, USER, PW)){
//				System.out.println(conn);
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//	}
	
}
