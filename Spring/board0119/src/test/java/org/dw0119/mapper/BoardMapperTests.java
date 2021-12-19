package org.dw0119.mapper;

import org.dw0119.domain.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
//	public void testGetList() {
//		System.out.println(mapper.getList());
//	}
	
//	public void testInsert() {
//		BoardVO board = new BoardVO();
//		board.setTitle("new");
//		board.setContent("new content");
//		board.setWriter("new writer");
//		
//		mapper.insert(board);
//		System.out.println("OKEY" + board.toString());
//	}
	
//	public void testInsertSelectKey() {
//		BoardVO board2 = new BoardVO();
//		board2.setTitle("new selectkey");
//		board2.setContent("new content selectkey");
//		board2.setWriter("new writer selectkey");
//		
//		mapper.insertSelectKey(board2);
//		System.out.println("OKEY" + board2.toString());
//	}
	
//	public void testRead() {
//		BoardVO board3 = mapper.read(6L);
//		System.out.println(board3.toString());
//	}
	
	public void testUpdate() {
		BoardVO boardupdate = new BoardVO();
		boardupdate.setBno(5L);
		boardupdate.setTitle("update");
		boardupdate.setContent("update");
		boardupdate.setWriter("update writer");
		
		int count = mapper.update(boardupdate);
		System.out.println("update: "+count);
	}

}
