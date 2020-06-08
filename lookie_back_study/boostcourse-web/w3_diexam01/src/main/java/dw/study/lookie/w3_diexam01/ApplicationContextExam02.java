package dw.study.lookie.w3_diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam02 {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		Car car = (Car)ac.getBean("c");
		car.run();
		//어떤 객체에게 다른 객체를 주입하는 것 : DI
		//장점 : 사용자는 사용할 클래스만 알아도 된다.
	}
}
