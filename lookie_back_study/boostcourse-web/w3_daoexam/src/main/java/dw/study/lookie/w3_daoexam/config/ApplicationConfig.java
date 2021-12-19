package dw.study.lookie.w3_daoexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration // 설정 정보 읽어들임
@ComponentScan(basePackages = {"dw.study.lookie.w3_daoexam.dao"}) //component scan으로 읽어낼 것이라는 것을 선언해주어야 함
@Import({ DBConfig.class }) // 설정파일을 여러개로 나누어 작성할 수 있음
public class ApplicationConfig {
	
}
