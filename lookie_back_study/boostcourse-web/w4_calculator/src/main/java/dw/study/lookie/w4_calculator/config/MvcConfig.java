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
	// DefaultServlet�� ���� ����
	// DispatcherServlet�� ó�� ���ϴ� URL�� DefaultServlet�� ó��
	// �ش� ������ ������ �ڵ� ������ Swagger �������� �� �� ����
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/*
	 * Swagger ��� �� Docket Bean�� ǰ�� �ִ� ���� Ŭ���� 1���� �⺻���� �ʿ��� (SpringBoot ������ �⺻ ���� ����
	 * 1���� Swagger�� Swagger UI�� �Բ� ��밡���ϳ� Spring MVC�� ��쿣 Swagger UI�� ���� ������ ������
	 * �ʿ���) Swagger UI�� ResourceHandler �� �������� ����ϴ� �۾�!
	 * 
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				// ���� RequestMapping���� �Ҵ�� ��� URL ����Ʈ ����
				.paths(PathSelectors.ant("/api/**"))
				// PathSelectors.any() : ��� ��ΰ� �� ���Ǿ� RestController�� �ƴ� �ͱ��� ���� -> ant�� �ؾ���
				.build().apiInfo(apiInfo()).useDefaultResponseMessages(false);
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("�ڵ���", "https://www.naver.com", "devdw98@gmail.com");
		ApiInfo apiInfo = new ApiInfo("Swagger Sample", "APIs Sample", "Sample Doc 0.1v", "", contact,
				"This sentence will be display", "/");
		return apiInfo;
	}
}
