package dw.study.lookie.w5_securityexam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import dw.study.lookie.w5_securityexam.service.security.CustomUserDetailsService;

//스프링 시큐리티 설정파일
// 로그인, 로그아웃, 인증, 인가 등을 처리하기 위한 파일
@Configuration
@EnableWebSecurity // 스프링 시큐리티를 구성하는 기본적인 빈들을 자동으로 구성
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	// 아이디에 해당하는 정보를 db에서 읽어들일 떄 UserDetailsService를 구현하고 있는 객체를 이용한다
	// -> 개발자가 만들어야하는 것 -> AuthenticationFilter에서 해당 객체를 사용한다!
	CustomUserDetailsService customUserDetailsService;

	@Override
	public void configure(WebSecurity web) throws Exception {
		// 해당 위치의 페이지들은 인증, 인가를 거치지 않도록 설정
		web.ignoring().antMatchers("/webjars/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http // 인증 인가 설정을 하겠다는 의미
				.csrf() // post 방식으로 값 전송 시 token을 사용해야하는 보안 설정(default로 설정되어있음)
				.disable() // csrf가 보안성을 높이나 개발 초기에는 방해가 될 수 있으므로 해당 설정을 함
				.authorizeRequests()
				.antMatchers("/", "/main", "/members/loginerror", "/members/joinform", "/members/join",
						"/members/welcome")
				.permitAll() // 해당 경로들에 대해서는 모두 접근이 가능하다
				.antMatchers("/securepage", "/members/**").hasRole("USER") //로그인 + USER 권한 가져야 접근 가능
				.anyRequest().authenticated() // 그 외의 경로들은 인증, 인가를 받아야 한다
				.and()
					.formLogin()
					.loginPage("/members/loginform") //로그인 폼의 경로
					.usernameParameter("userId") //input tag name
					.passwordParameter("password") //input tag name
					.loginProcessingUrl("/authenticate") //로그인 처리 경로 -> 스프링 시큐리티 필터가 처리 -> 개발 X
					.failureForwardUrl("/members/loginerror?login_error=1") //로그인 처리 실패 시 포워딩 경로 -> 개발O
					.defaultSuccessUrl("/", true) // 로그인 성공 시 / 로 리다이렉트
					.permitAll() //로그인 폼은 아무나 접근 가능! (로그인한 사람은 접근하면 안됨)
				.and()
					.logout()//로그아웃 요청 시 로그인 정보 삭제 후 /로 리다이렉트
					.logoutUrl("/logout") 
					.logoutSuccessUrl("/");
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(); // 암호 인코딩, 사용자가 입력한 암호가 같은지 확인
	}

}
