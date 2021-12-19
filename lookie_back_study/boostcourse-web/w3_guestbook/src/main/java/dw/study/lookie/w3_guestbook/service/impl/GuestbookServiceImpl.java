package dw.study.lookie.w3_guestbook.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dw.study.lookie.w3_guestbook.dao.GuestbookDao;
import dw.study.lookie.w3_guestbook.dao.LogDao;
import dw.study.lookie.w3_guestbook.dto.Guestbook;
import dw.study.lookie.w3_guestbook.dto.Log;
import dw.study.lookie.w3_guestbook.service.GuestbookService;

@Service //service Layer이다!
public class GuestbookServiceImpl implements GuestbookService{
	
	@Autowired //자동으로 빈 등록
	GuestbookDao gDao;
	
	@Autowired
	LogDao lDao;
	
	@Override
	@Transactional(readOnly=false) //
	public Guestbook addGuestbook(Guestbook gb, String ip) {
		//db에 데이터 넣는 작업
		gb.setRegdate(new Date());
		Long id = gDao.insert(gb);
		gb.setId(id); //log에 남기기 위해
		
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("insert");
		log.setRegdate(new Date());
		lDao.insert(log);
		
		return gb;
	}
	@Override
	@Transactional(readOnly=false) //
	public int deleteGuestbook(Long id, String ip) {
		int delCount = gDao.deleteById(id);
		
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("delete");
		log.setRegdate(new Date());
		lDao.insert(log);
		
		return delCount;
	}
	@Override
	public int getCount() {
		//paging 처리
		return gDao.selectCount();
	}
	@Override
	@Transactional //읽기만 하는 메서드 -> 트랜잭션 처리 시 내부적으로 readOnly형태로 커넥션을 사용함
	public List<Guestbook> getGuestbooks(Integer start) {
		//guestbook 목록, 페이징처리 해야함
		List<Guestbook> list = gDao.selectAll(start, LIMIT);
		return list;
	}
	
	
}
