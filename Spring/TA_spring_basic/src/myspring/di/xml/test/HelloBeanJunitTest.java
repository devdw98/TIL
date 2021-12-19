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
		// ApplicationContext�� @Test �ÿ� ���� ȣ��Ǿ�� �ϴ� �ڵ��
		// @Before�� �̸� �ʱ�ȭ �ϴ� �۾��� ���� �Ѵ�.
		// 1. IoC Container ���� -> ApplicationContext ��ü ����
		context = new GenericXmlApplicationContext("config/beans.xml");
	}

	@Test
	public void test2() {
		// 2.Hello Bean ��������
		Hello hello = (Hello) context.getBean("hello");
		Hello hello2 = (Hello) context.getBean("hello");
		
		assertSame(hello, hello2);
		//Spring Container�� �ش�Ǵ� Bean ��ü�� �̱������� �����Ѵ�
	}

	@Test @Ignore
	public void test1() {
		// 2.Hello Bean ��������
		Hello hello = (Hello) context.getBean("hello");
		assertEquals("Hello Spring", hello.sayHello());
		hello.print();
		// 3. StringPrinter Bean ��������
		Printer printer = context.getBean("printer", Printer.class);
		assertEquals("Hello Spring", printer.toString());
	}

}
