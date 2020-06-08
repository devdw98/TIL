package dw.study.lookie.w3_diexam01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // config 파일이라는 것을 선언함
public class ApplicationConfig {
	@Bean
	public Car c(Engine e) {
		Car c = new Car();
		c.setEngine(e);
		return c;
	}
	
	@Bean
	public Engine engine() {
		return new Engine();
	}
}
