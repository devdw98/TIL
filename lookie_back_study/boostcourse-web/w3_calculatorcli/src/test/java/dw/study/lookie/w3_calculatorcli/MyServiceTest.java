package dw.study.lookie.w3_calculatorcli;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;

import junit.framework.Assert;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(MockitoJUnitRunner.class) // 가짜 객체 생성 후 테스트 하는 코드
public class MyServiceTest {

//	@Autowired
//	MyService m;

	@InjectMocks // Mock 객체를 사용하는 객체 자동 생성 + 필드 초기화
	MyService ms;

	@Mock // Mock 객체를 참조하도록 함.객체 생성 안해도 자동 생성 + 필드 초기화 됨
	CalculatorService cs;

	@Test
	public void execute() throws Exception {
		int a = 1;
		int b = 4;
		given(cs.plus(1, 4)).willReturn(5); 
		//가짜 객체가 동작하는 방법을 규정할 수 있음
		//cs.plus(1,4)를 호출하면 plus 메소드가 5를 반환하도록 하라

//		int result = m.execute(a, b);
		int result = ms.execute(a, b);

		verify(cs).plus(anyInt(), anyInt());
		//verify: 파라미터로 들어온 객체의 plus 메소드가 호출된 적이 있는 지 검증
		//		   어떤 정수든지 2개를 파라미터로 넣어서 plus 메소드를 호출했는지 검증
		// ms.execute()메소드 내부적으로 plus 메소드를 호출했다면 해당 메소드는 검증을 성공한 것
		//호출하지 않았다면 오류 발생
		Assert.assertEquals(10, result);
	}

}
