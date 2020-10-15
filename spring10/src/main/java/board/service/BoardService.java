package board.service;

import java.util.List;

import board.domain.BoardVo;

public interface BoardService {
	public List<BoardVo> list();
	
	public int delete(BoardVo boardVo);
	
	public int edit(BoardVo boardVo);
	
	public void write(BoardVo boardVo);
	
	public BoardVo read(int seq);
}
