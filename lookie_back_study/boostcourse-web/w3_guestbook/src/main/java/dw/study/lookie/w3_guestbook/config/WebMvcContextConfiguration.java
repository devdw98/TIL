package dw.study.lookie.w3_guestbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import dw.study.lookie.w3_guestbook.interceptor.LogInterceptor;

@Configuration // 설정파일이라는 것을 알려줌
@EnableWebMvc // 기본 설정 자동으로 해줌
@ComponentScan(basePackages = { "dw.study.lookie.w3_guestbook.controller" }) // controller 읽어노는 annotation
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter { // 원하는 설정 하기 위해 adapter 상속받음
	// spring mvc 강의에서 공부한 내용
	// 필요한 메소드 오버라이드 -> dispather servlet이 읽어들일 수 있도록 함!

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registory) {
		// url 요청이 앞의 string 처럼 들어오는 것들은 뒤의 지정한 폴더에서 읽어와주세요
		registory.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
		registory.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
		registory.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configure) {
		// default servlet controller를 사용하게 함
		configure.enable();
		// 매핑 정보가 없는 url 요청이 들어왔을 때 spring의 DefaultServletHttpRequestHandler가 처리하도록 함
		// WAS의 default servlet이 static 한 자원을 읽어서 보여줄 수 있게끔 하는 설정
	}

	@Override
	public void addViewControllers(final ViewControllerRegistry registory) {
		// 특정 URL에 대한 처리를 controller class를 작성하지 않고 매핑할 수 있도록 하는 부분
		System.out.println("addViewControllers가 호출됨");
		registory.addViewController("/").setViewName("index");
	}

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		//적절한 view resolver가 실제로 view의 이름을 가지고 어떤 view인지 찾아낼 수 있게 해줌
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LogInterceptor());
	}

}
