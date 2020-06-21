package dw.study.lookie.pr_naver_reservation_api.config;

import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//스프링 mvc 설정파일
@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = { "dw.study.lookie.pr_naver_reservation_api.controller" })
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override //spring mvc 에서 jsp view가 위치하는 경로 설정
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/view/", ".jsp");
	}
	
	@Override // '/'로 요청 오면 '/main'으로 리다이렉트 함
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/main");
	}
	
	@Override // /resources 경로에 있는 자료들을 /resources/** 로 접근하게 함
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	
	//swagger2
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any()) // // 현재 RequestMapping으로 할당된 모든 URL 리스트를 추출
				.paths(PathSelectors.ant("/api/**"))// PathSelectors.any() 를 할경우 모든 경로가 다 사용된다. RestController가 아닌 것 까지 사용된다.
				.build()
				.apiInfo(apiInfo())
				.useDefaultResponseMessages(false);
	}
	
	private ApiInfo apiInfo() {
		String title = "naver_reservation_api";
		String description = "네이버 예약 API 실습";
		String version = "1.0";
		String termsOfServiceUrl = "local";
		Contact contact = new Contact("박도원", "https://github.com/devdw98", "devdw98@gmail.com");
		String contactName = "박도원";
		String license = "dw";
		String licenseUrl = "dw";
//		Collection<VendorExtension> vendorExtensions = ;
//		ApiInfo apiInfo = new ApiInfo(title, description, version, termsOfServiceUrl, contact, license, licenseUrl, vendorExtensions);
		ApiInfo apiInfo2 = new ApiInfo(title, description, version, termsOfServiceUrl, contactName, license, licenseUrl);
		return apiInfo2;
	}


}
