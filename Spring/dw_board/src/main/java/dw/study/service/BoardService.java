package dw.study.service;

import java.util.List;

import dw.study.domain.BoardVO;
import dw.study.domain.Criteria;

public interface BoardService {

	public void register(BoardVO board);
	public BoardVO get(int bno);
	public boolean update(BoardVO board);
	public boolean remove(int bno);
//	public List<BoardVO> getList();
	public List<BoardVO> getList(Criteria cri);
}
