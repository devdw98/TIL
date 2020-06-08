package dw.study.lookie.w3_diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam01 {
	public static void main(String[] args) {
		// spring 공장 생성
		//ClassPathXmlApplicationContext : xml파일을 classpath에서 읽어서 사용하는 객체
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println("초기화 완료");

		UserBean userBean = (UserBean) ac.getBean("userBean"); //getBean의 string은 등록해둔 bean의 id
		userBean.setName("kang");
		System.out.println(userBean.getName());
		
		UserBean userBean2 = (UserBean)ac.getBean("userBean");
		
		if(userBean == userBean2) {
			System.out.println("같은 인스턴스 입니다.");
			//bean을 계속 요청하더라도 하나 만든 bean을 이용하는 것임
		}
	}
}
