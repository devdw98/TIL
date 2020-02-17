package dw.study.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dw.study.domain.BoardVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testUpdate() {
		int bno = 5;
		String title = "새로운 타이틀";
		String content = "새로운 컨텐츠";
		String writer = "수정된 writer";
		BoardVO board = new BoardVO();
		board.setBno(bno);
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		
		int count = mapper.update(board);
		mapper.getList();
	}
	public void testDelete() {
		mapper.delete(2);
		mapper.getList();
	}
	public void testRead() {
		BoardVO board = mapper.read(7);
		
	}
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("new title");
		board.setContent("new Content");
		board.setWriter("new Writer");
		
		mapper.insert(board);
		mapper.getList();
	}
	public void testGetList() {
		mapper.getList();
	}
	
}
