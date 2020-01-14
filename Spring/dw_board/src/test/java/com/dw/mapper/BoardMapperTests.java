package com.dw.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dw.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	@Test
//	public void testGetList() {
//		mapper.getList().forEach(board -> log.info(board));
//	}
//	public void testInsert() {
//		String title = "new title";
//		String content = "new content";
//		String writer = "new writer";
//		
//		BoardVO board = new BoardVO();
//		board.setTitle(title);
//		board.setContent(content);
//		board.setWriter(writer);
//		
//		mapper.insert(board);
//		
//		log.info(board); //bno 멤버 변수의 값을 알아보기 위함
//	}
	
//	public void testInsertSelectKey() {
//		String title = "new title key";
//		String content = "new content key";
//		String writer = "new writer key";
//		
//		BoardVO board = new BoardVO();
//		board.setTitle(title);
//		board.setContent(content);
//		board.setWriter(writer);
//		
//		mapper.insertSelectKey(board);
//		
//		log.info(board); //bno 멤버 변수의 값을 알아보기 위함
//		
//	}
	
//	public void testRead() {
//		//존재하는 게시물 번호로 TEST
//		BoardVO board = mapper.read(5L);
//		
//		log.info(board);
//	}
	
//	public void testDelete() {
//		log.info("DELETE COUNT: "+mapper.delete(3L));
//	}
	
	public void testUpdate() {
		String title = "update title";
		String content = "update content";
		String writer = "user01";
		BoardVO board = new BoardVO();
		//실행전 존재하는 번호인지 확인하기
		board.setBno(5L);
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT: "+count);
	}
	

}
