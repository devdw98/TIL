package dw.study.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import dw.study.domain.BoardVO;

public interface BoardMapper { //2. SQL �۾��� �� Mapper Interface �ۼ�
	
//	@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();

}
