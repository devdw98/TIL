package com.dw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.domain.BoardVO;
import com.dw.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

//@Log4j
@Service //계층 구조상 비즈니스 영역을 담당하는 객체임을 표시
@AllArgsConstructor //모든 파라미터를 이용하는 생성자를 만듦
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_ = {@Autowired})
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) { //등록 작업 구현
		
//		log.info("register......"+ board);
		mapper.insertSelectKey(board); 
		
	}

	public void setMapper(BoardMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		return mapper.update(board)==1;
	}

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		return mapper.delete(bno)==1;
	}

	@Override
	public List<BoardVO> getList() { //목록 구현
		// TODO Auto-generated method stub
		
		return mapper.getList();
	}
	
	
}
