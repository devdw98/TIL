package dw.study.mapper;

import java.util.List;

import dw.study.domain.BoardVO;
import dw.study.domain.Criteria;

public interface BoardMapper { //2. SQL �۾��� �� Mapper Interface �ۼ�
	
//	@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	public void insert(BoardVO board);
	public BoardVO read(int bno);
	public int delete(int bno);
	public int update(BoardVO board);
	
	public List<BoardVO> getListWithPaging(Criteria cri);

}
