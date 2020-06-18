package dw.study.lookie.pr_naver_reservation_api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "dw.study.lookie.pr_naver_reservation_api.service",
		"dw.study.lookie.pr_naver_reservation_api.dao" })
@Import(DBConfig.class)
public class ApplicationConfig {

}
