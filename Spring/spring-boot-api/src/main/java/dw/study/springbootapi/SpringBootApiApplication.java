package dw.study.springbootapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApiApplication.class, args);
    }

    @Bean
    public RestTemplate getResTamplete(){ //kakao와의 통신 필요
        return new RestTemplate();
    }

}
