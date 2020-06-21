package dw.study.lookie.pr_naver_reservation_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//스프링 시큐리티를 이용해 로그인/로그아웃/인증/인가 등을 처리하기 위한 설정 파일
@Configuration
@EnableWebSecurity //스프링 시큐리티를 구성하는 기본적인 빈들을 자동으로 구성해줌
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	public void configure(WebSecurity web) throws Exception{
		//인증,인가가 필요없는 경로를 설정할 필요가 있을 때 오버라이딩
		web.ignoring().antMatchers("/webjars/**"); // 무시될 경로 지정
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//인증, 인가에 대한 설정을 할 때 오버라이딩
		http
		.csrf().disable()
		.authorizeRequests().antMatchers("/","/main").permitAll()
		.anyRequest().authenticated();
	}
	
	@Bean
	public PasswordEncoder encoder() {
		//암호 인코딩 , 인코딩된 암호와 사용자가 입력한 암호가 같은지 확인할 때 사용
		return new BCryptPasswordEncoder();
	}
}
