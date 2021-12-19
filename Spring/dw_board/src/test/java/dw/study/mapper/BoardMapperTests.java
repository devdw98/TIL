package dw.study.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dw.study.domain.BoardVO;
import dw.study.domain.Criteria;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		cri.setPageNum(3);
		cri.setAmount(10);
		System.out.println(cri.getResult());
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		System.out.println(list);
	}
	
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
