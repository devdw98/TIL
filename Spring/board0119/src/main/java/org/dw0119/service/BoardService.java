package org.dw0119.service;

import java.util.List;

import org.dw0119.domain.BoardVO;

public interface BoardService {
	
	public void register(BoardVO board);
	public BoardVO get(Long bno);
	public boolean modify(BoardVO board);
	public boolean delete(Long bno);
	public List<BoardVO> getList();

}
