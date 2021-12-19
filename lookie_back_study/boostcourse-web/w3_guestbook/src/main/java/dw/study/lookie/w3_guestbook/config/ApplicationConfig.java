package dw.study.lookie.w3_guestbook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"dw.study.lookie.w3_guestbook.dao", "dw.study.lookie.w3_guestbook.service"})
//해당하는 파일에 구현되어있는 component들을 읽어와야하기 때문에 필요한 것
@Import({DBConfig.class})//ComponentScan이 실행될 때 DBConfig에 사용되고 있는 것들을 써야 함
public class ApplicationConfig {

}
