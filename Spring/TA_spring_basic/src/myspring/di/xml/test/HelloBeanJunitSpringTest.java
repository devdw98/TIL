package myspring.di.xml.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/beans.xml"})
public class HelloBeanJunitSpringTest {
	@Autowired
	ApplicationContext context;

//	@Before
//	//Spring-test 에서는 이 부분을 라이브러리에서 해줌 -> 할 필요 X
//	public void init() {
//		// ApplicationContext는 @Test 시에 먼저 호출되어야 하는 코드라
//		// @Before로 미리 초기화 하는 작업을 따로 한다.
//		// 1. IoC Container 생성 -> ApplicationContext 객체 생성
//		context = new GenericXmlApplicationContext("config/beans.xml");
//	}

	@Test @Ignore
	public void test2() {
		// 2.Hello Bean 가져오기
		Hello hello = (Hello) context.getBean("hello");
		Hello hello2 = (Hello) context.getBean("hello");
		
		assertSame(hello, hello2);
		//Spring Container는 해당되는 Bean 객체를 싱글톤으로 관리한다
	}

	@Test 
	public void test1() {
		// 2.Hello Bean 가져오기
		Hello hello = (Hello) context.getBean("hello2");
		assertEquals("Hello Spring", hello.sayHello());
		hello.print();
		
		assertEquals(3,hello.getNames().size());
		List<String> list = hello.getNames();
		for(String value: list) {
			System.out.println(value);
		}
		
		// 3. StringPrinter Bean 가져오기
		Printer printer = context.getBean("printer", Printer.class);
		assertEquals("Hello Spring", printer.toString());
	}

}
