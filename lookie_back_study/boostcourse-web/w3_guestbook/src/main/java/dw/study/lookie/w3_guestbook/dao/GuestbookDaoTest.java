package dw.study.lookie.w3_guestbook.dao;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dw.study.lookie.w3_guestbook.config.ApplicationConfig;
import dw.study.lookie.w3_guestbook.dto.Guestbook;
import dw.study.lookie.w3_guestbook.dto.Log;

public class GuestbookDaoTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//		GuestbookDao gDao = ac.getBean(GuestbookDao.class);
//		Guestbook gb = new Guestbook();
//		gb.setName("dw");
//		gb.setContent("안녕");
//		gb.setRegdate(new Date());
//		Long id = gDao.insert(gb);
//		System.out.println(id);
		
		LogDao lDao = ac.getBean(LogDao.class);
		Log log = new Log();
		log.setIp("127.0.0.1");
		log.setMethod("insert");
		log.setRegdate(new Date());
		Long Lid = lDao.insert(log);
		System.out.println(Lid);
	}

}
