package dw.study.lookie.w3_calculatorcli;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class) 
//JUnit이 테스트코드 실행 시 스프링 빈 컨테이너가 내부적으로 생성되게 함
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
//내부적으로 생성된 스프링 빈 컨테이너가 사용할 설정 파일 지정 시 사용
//@ContextConfiguration(classes = {ApplicationConfig.class}) 는 javaConfig 시 사용
public class CalculatorServiceTest {
	
	@Autowired
	CalculatorService c;

//	@Before
//	public void init() {
//		this.c = new CalculatorService();
//	}

	@Test
	public void plus() throws Exception {
		// given
		int a = 10;
		int b = 5;
		// when
		int result = c.plus(a, b);

		Assert.assertEquals(15, result);
	}

	@Test
	public void divide() throws Exception {
		// given
		int value1 = 10;
		int value2 = 5;

		// when
		int result = c.divide(value1, value2);

		// then
		Assert.assertEquals(2, result); // 결과와 2가 같을 경우에만 성공
	}

	@Test
	public void divideExceptionTest() throws Exception {
		// given
		int value1 = 10;
		int value2 = 0;

		try {
			c.divide(value1, value2);
		} catch (ArithmeticException ae) {
			Assert.assertTrue(true); // 이부분이 실행되었다면 성공
			return; // 메소드를 더이상 실행하지 않는다.
		}
		Assert.fail(); // 이부분이 실행되면 무조건 실패다.

	}

}
