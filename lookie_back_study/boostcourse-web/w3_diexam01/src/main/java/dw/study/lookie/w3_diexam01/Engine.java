package dw.study.lookie.w3_diexam01;

import org.springframework.stereotype.Component;

@Component //ApplicationConfig2 예제 실행 시 필요
public class Engine {
	public Engine() {
		System.out.println("Engine 생성자");
	}

	public void exec() {
		System.out.println("엔진 동작");
	}
}
