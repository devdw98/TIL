package dw.study.lookie.w3_guestbook.service.impl;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dw.study.lookie.w3_guestbook.config.ApplicationConfig;
import dw.study.lookie.w3_guestbook.dto.Guestbook;
import dw.study.lookie.w3_guestbook.service.GuestbookService;

public class GuestbookServiceImplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		GuestbookService gbService = ac.getBean(GuestbookService.class);
		
		Guestbook gb = new Guestbook();
		gb.setName("dwtest");
		gb.setContent("서비스 테스트");
		gb.setRegdate(new Date());
		
		Guestbook result = gbService.addGuestbook(gb, "127.0.0.1");
		System.out.println(result);

	}

}
