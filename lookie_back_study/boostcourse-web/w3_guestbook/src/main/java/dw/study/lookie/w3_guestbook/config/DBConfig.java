package dw.study.lookie.w3_guestbook.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration // 설정파일임을 알림
@EnableTransactionManagement // 트랜잭션과 관련된 설정 자동으로 해줌
//위 annotation을 사용하기 위해선 TransactionManagementConfigurer를 구현해야함
public class DBConfig implements TransactionManagementConfigurer {

	private String driverClassName = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/lookiedb?serverTimezone=Asia/Seoul&useSSL=false";
	private String username = "dw";
	private String password = "dw";

	@Bean
	public DataSource dataSource() { 
		//db연결을 위한 bean
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);

		return ds;
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return transactionManager();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		//트랜잭션을 처리할 platformTransactionManager 객체 반환
		return new DataSourceTransactionManager(dataSource());
	}
}
