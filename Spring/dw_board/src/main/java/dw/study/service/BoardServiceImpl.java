package dw.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dw.study.domain.BoardVO;
import dw.study.mapper.BoardMapper;

@Service //����Ͻ� ������ ����ϴ� ��ü���� ǥ���ϱ����� �����
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board){
		mapper.insert(board);
	}
	@Override
	public BoardVO get(int bno){
		return mapper.read(bno);
		
	}
	@Override
	public boolean update(BoardVO board){
		return mapper.update(board) == 1;
	}
	@Override
	public boolean delete(int bno){
		return mapper.delete(bno) ==1;
	}
	@Override
	public List<BoardVO> getList(){
		return mapper.getList();
	}
}
