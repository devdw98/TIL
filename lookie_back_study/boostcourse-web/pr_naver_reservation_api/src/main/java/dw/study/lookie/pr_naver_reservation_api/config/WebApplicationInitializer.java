package dw.study.lookie.pr_naver_reservation_api.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//web.xml 파일 대신하는 자바 config 파일
public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	//Spring 기본 설정파일 클래스 지정
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {ApplicationConfig.class, SecurityConfig.class};
	}
	
	//Spring MVC 설정 파일 클래스 지정
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {MvcConfig.class};
	}

	//DispatcherServlet이 동작할 맵핑정보 설정
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	//필터 설정
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter=new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		
		return new Filter[] {encodingFilter};
	}

}
