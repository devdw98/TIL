package dw.study.lookie.w3_calculatorcli;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		//ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		//javaConfig 시 사용하는 코드
		System.out.println("초기화 완료");
		
		CalculatorService cs = (CalculatorService)ac.getBean("calculatorService");
		//CalculatorService cs = ac.getBean(CalculatorService.class);
		//javaConfig 시 사용하는 코드
		System.out.println(cs.plus(2, 4));
		
	}
}
