package dw.study.lookie.w3_diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExam04 {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig2.class);
		Car car = (Car) ac.getBean(Car.class); // getBean에 타입이 들어와도 됨
		car.run();
	}
}
