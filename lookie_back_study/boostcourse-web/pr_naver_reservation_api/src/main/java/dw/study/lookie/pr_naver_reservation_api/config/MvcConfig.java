package dw.study.lookie.pr_naver_reservation_api.config;

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
@ComponentScan(basePackages = { "dw.study.lookie.pr_naver_reservation_api.controller" })
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.ant("/api/**"))
//				.build().apiInfo(apiInfo()).useDefaultResponseMessages(false);
//	}
//
//	private ApiInfo apiInfo() {
//		Contact contact = new Contact("박도원", "https://github.com/devdw98", "devdw98@gmail.com");
//		ApiInfo apiInfo = new ApiInfo("title", "description", "version", "termsOfServiceUrl", contact, "license", "licenseUrl", null);
//		return apiInfo;
//	}


}
