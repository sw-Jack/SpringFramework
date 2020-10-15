package board.persistence;

import java.util.List;

import board.domain.BoardVo;

public interface BoardDao {
	public List<BoardVo> list();
	
	public int delete(BoardVo boardVo);
	
	public int update(BoardVo boardVo);
	
	public void insert(BoardVo boardVo);
	
	public BoardVo select(int seq);
	
	public int updateReadCount(int seq);
}
