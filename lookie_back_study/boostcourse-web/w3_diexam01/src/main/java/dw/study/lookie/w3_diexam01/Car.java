package dw.study.lookie.w3_diexam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //ApplicationConfig2 예제 실행 시 필요
public class Car {
	@Autowired //ApplicationConfig2 예제 실행 시 필요
	//Engine객체가 생성된게 있으면 알아서 주입해줘
	Engine v8;

	public Car() {
		System.out.println("Car 생성자");
	}

// ApplicationConfig2 예제 실행 시 주석처리	
	public void setEngine(Engine e) {
		this.v8 = e;
	}

	public void run() {
		System.out.println("엔진을 이용해 달립니다.");
		v8.exec();
	}

//	public static void main(String[] args) {
//		//이렇게 객체가 만들어져야 하는데 스프링에서는 제어의 역전 (IoC) 컨테이너로 만들 것
//		Engine e = new Engine();
//		Car c = new Car();
//		c.setEngine(e);
//		c.run();
//	}
}
