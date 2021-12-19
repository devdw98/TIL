package dw.study.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class DataSourceTest { 
	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testMyBatis() { //Mybatis connection Test
		try(SqlSession session = sqlSessionFactory.openSession();
				Connection con = session.getConnection();
				){
			System.out.println(session);
			System.out.println(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testConnection() { //HikariCP connection test
		try(Connection con = ds.getConnection()){
			System.out.println(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
