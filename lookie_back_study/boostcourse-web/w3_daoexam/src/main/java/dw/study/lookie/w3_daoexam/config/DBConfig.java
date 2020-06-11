package dw.study.lookie.w3_daoexam.config;


import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement //트랜잭션때문에 필요한 설정
public class DBConfig {

	private String driverClassName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/lookiedb?serverTimezone=Asia/Seoul&useSSL=false";
	private String username = "dw";
	private String password = "dw";
	
	@Bean //데이터소스 객체 사용하기 위한 설정
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}
	
}
