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
//	//Spring-test ������ �� �κ��� ���̺귯������ ���� -> �� �ʿ� X
//	public void init() {
//		// ApplicationContext�� @Test �ÿ� ���� ȣ��Ǿ�� �ϴ� �ڵ��
//		// @Before�� �̸� �ʱ�ȭ �ϴ� �۾��� ���� �Ѵ�.
//		// 1. IoC Container ���� -> ApplicationContext ��ü ����
//		context = new GenericXmlApplicationContext("config/beans.xml");
//	}

	@Test @Ignore
	public void test2() {
		// 2.Hello Bean ��������
		Hello hello = (Hello) context.getBean("hello");
		Hello hello2 = (Hello) context.getBean("hello");
		
		assertSame(hello, hello2);
		//Spring Container�� �ش�Ǵ� Bean ��ü�� �̱������� �����Ѵ�
	}

	@Test 
	public void test1() {
		// 2.Hello Bean ��������
		Hello hello = (Hello) context.getBean("hello2");
		assertEquals("Hello Spring", hello.sayHello());
		hello.print();
		
		assertEquals(3,hello.getNames().size());
		List<String> list = hello.getNames();
		for(String value: list) {
			System.out.println(value);
		}
		
		// 3. StringPrinter Bean ��������
		Printer printer = context.getBean("printer", Printer.class);
		assertEquals("Hello Spring", printer.toString());
	}

}
