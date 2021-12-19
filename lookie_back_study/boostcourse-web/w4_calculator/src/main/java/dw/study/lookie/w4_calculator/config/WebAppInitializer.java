package dw.study.lookie.w4_calculator.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	//Spring 기본 설정파일 클래스 지정
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {ApplicationConfig.class};
	}
	
	//Spring MVC 설정 파일 클래스 지정
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {MvcConfig.class};
	}

	//DispatcherServlet이 동작할 맵핑정보 설정
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
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
