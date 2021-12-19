package org.dw0119.service;

import java.util.List;

import org.dw0119.domain.BoardVO;
import org.dw0119.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		log.info("register..."+board);
		mapper.insertSelectKey(board);
	}
	
	@Override
	public BoardVO get(Long bno) {
		log.info("get..."+bno);
		return mapper.read(bno);
	}
	@Override
	public boolean modify(BoardVO board) {
		log.info("modify..."+board);
		return mapper.update(board) == 1;
	}
	@Override
	public boolean delete(Long bno) {
		log.info("delete..."+bno);
		return mapper.delete(bno)==1;
	}
	@Override
	public List<BoardVO> getList(){
		log.info("getList...");
		
		return mapper.getList();
	}

}
