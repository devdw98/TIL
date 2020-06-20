package dw.study.lookie.w5_securityexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//스프링 설정파일
@Configuration
@ComponentScan(basePackages= {"dw.study.lookie.w5_securityexam.dao", "dw.study.lookie.w5_securityexam.service"})
public class ApplicationConfig {

}
