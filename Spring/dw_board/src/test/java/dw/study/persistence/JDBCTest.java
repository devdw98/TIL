package dw.study.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JDBCTest {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/studydb?characterEncoding=utf8&serverTimezone=UTC";
	private static final String USER = "study";
	private static final String PASSWORD = "study";
	
	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){
			System.out.println("success");
			System.out.println(conn);
		}catch(Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}
}
