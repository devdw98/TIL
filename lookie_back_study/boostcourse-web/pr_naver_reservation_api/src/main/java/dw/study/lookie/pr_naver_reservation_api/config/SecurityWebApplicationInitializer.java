package dw.study.lookie.pr_naver_reservation_api.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

//스프링 시큐리티 사용하려면 반드시 AbstractSecurityWebApplicationInitializer 클래스를 상속받는 클래스를 작성해야함
// 해당 클래스는 스프링 시큐리티가 제공하는 필터들을 사용할 수 있게 활성화해줌
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer{

}
