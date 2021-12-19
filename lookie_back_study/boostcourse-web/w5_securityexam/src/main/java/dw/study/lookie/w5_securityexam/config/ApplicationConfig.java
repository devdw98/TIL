package dw.study.lookie.w5_securityexam.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

//스프링 설정파일
@Configuration
@ComponentScan(basePackages= {"dw.study.lookie.w5_securityexam.dao", "dw.study.lookie.w5_securityexam.service"})
@EnableTransactionManagement //어노테이션으로 트랜잭션 관리
public class ApplicationConfig implements TransactionManagementConfigurer{
	private String driverClassName = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/lookiedb?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
    private String username = "dw";
    private String password = "dw";
    
    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }
    
    /**
     * 트랜잭션 관리자를 생성한다.
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return transactionManager();
    }
}
