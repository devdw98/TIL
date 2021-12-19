package myspring.di.xml.test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

import static org.junit.Assert.*;

public class HelloBeanJunitTest {
	ApplicationContext context;

	@Before
	public void init() {
		// ApplicationContext는 @Test 시에 먼저 호출되어야 하는 코드라
		// @Before로 미리 초기화 하는 작업을 따로 한다.
		// 1. IoC Container 생성 -> ApplicationContext 객체 생성
		context = new GenericXmlApplicationContext("config/beans.xml");
	}

	@Test
	public void test2() {
		// 2.Hello Bean 가져오기
		Hello hello = (Hello) context.getBean("hello");
		Hello hello2 = (Hello) context.getBean("hello");
		
		assertSame(hello, hello2);
		//Spring Container는 해당되는 Bean 객체를 싱글톤으로 관리한다
	}

	@Test @Ignore
	public void test1() {
		// 2.Hello Bean 가져오기
		Hello hello = (Hello) context.getBean("hello");
		assertEquals("Hello Spring", hello.sayHello());
		hello.print();
		// 3. StringPrinter Bean 가져오기
		Printer printer = context.getBean("printer", Printer.class);
		assertEquals("Hello Spring", printer.toString());
	}

}
