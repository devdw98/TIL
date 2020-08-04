package kr.or.connect.roleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //springboot 설정 파일 이면서 application이다! + basePackages
public class RoleappApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoleappApplication.class, args);
	}

}
