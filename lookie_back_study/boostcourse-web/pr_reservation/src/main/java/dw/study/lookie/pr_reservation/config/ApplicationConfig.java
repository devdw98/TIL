package dw.study.lookie.pr_reservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"dw.study.lookie.pr_reservation.dao","dw.study.lookie.pr_reservation.service"})
@Import({DBConfig.class})
public class ApplicationConfig {

}
