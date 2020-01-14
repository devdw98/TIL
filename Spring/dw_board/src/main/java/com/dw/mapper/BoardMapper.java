package com.dw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.dw.domain.BoardVO;

public interface BoardMapper {
	
//	@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	public void insert(BoardVO board); //insert 후 pk값 알 필요 없는 경우
	
	public void insertSelectKey(BoardVO board); //insert 후 pk값 알아야 하는 경우
	
	public BoardVO read(Long bno); //데이터 조회
	
	public int delete(Long bno); //데이터 삭제 (정상적으로 데이터 삭제 시 return 1)
	
	public int update(BoardVO board); //데이터 수정 (몇 개의 데이터가 수정되었는가 처리를 위해 int 타입으로 설계)

}
