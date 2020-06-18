package dw.study.lookie.pr_naver_reservation_api.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	//Spring 기본 설정파일 클래스 지정
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {ApplicationConfig.class};
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
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter=new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		
		return new Filter[] {encodingFilter};
	}

}
