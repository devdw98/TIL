package dw.study.lookie.w4_calculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = { "dw.study.lookie.w4_calculator.controller" })
public class MvcConfig implements WebMvcConfigurer {
	// DefaultServlet에 대한 설정
	// DispatcherServlet이 처리 못하는 URL은 DefaultServlet이 처리
	// 해당 설정이 없으면 자동 생성된 Swagger 페이지를 볼 수 없음
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/*
	 * Swagger 사용 시 Docket Bean을 품고 있는 설정 클래스 1개가 기본으로 필요함 (SpringBoot 에서는 기본 설정 파일
	 * 1개로 Swagger와 Swagger UI를 함께 사용가능하나 Spring MVC의 경우엔 Swagger UI를 위한 별도의 설정이
	 * 필요함) Swagger UI를 ResourceHandler 에 수동으로 등록하는 작업!
	 * 
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				// 현재 RequestMapping으로 할당된 모든 URL 리스트 추출
				.paths(PathSelectors.ant("/api/**"))
				// PathSelectors.any() : 모든 경로가 다 사용되어 RestController가 아닌 것까지 사용됨 -> ant로 해야함
				.build().apiInfo(apiInfo()).useDefaultResponseMessages(false);
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("박도원", "https://www.naver.com", "devdw98@gmail.com");
		ApiInfo apiInfo = new ApiInfo("Swagger Sample", "APIs Sample", "Sample Doc 0.1v", "", contact,
				"This sentence will be display", "/");
		return apiInfo;
	}
}
