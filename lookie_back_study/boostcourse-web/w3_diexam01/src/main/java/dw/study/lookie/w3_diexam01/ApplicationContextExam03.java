package dw.study.lookie.w3_diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExam03 {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//		Car car = (Car)ac.getBean("c");
		Car car = (Car)ac.getBean(Car.class); //getBean에 타입이 들어와도 됨
		car.run();
	}
}
