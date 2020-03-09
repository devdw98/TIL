package dw.study.service;

import java.util.List;

import dw.study.domain.BoardVO;

public interface BoardService {

	public void register(BoardVO board);
	public BoardVO get(int bno);
	public boolean update(BoardVO board);
	public boolean delete(int bno);
	public List<BoardVO> getList();
}
