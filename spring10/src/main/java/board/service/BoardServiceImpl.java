package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.domain.BoardVo;
import board.persistence.BoardDao;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	
	
	//public BoardDao getBoardDao() {
	//	return boardDao;
	//}

	//public void setBoardDao(BoardDao boardDao) {
	//	this.boardDao = boardDao;
	//}

	@Override
	public List<BoardVo> list() {
		return boardDao.list();
	}

	@Override
	public int delete(BoardVo boardVo) {
		return boardDao.delete(boardVo);
	}

	@Override
	public int edit(BoardVo boardVo) {
		return boardDao.update(boardVo);
	}

	@Override
	public void write(BoardVo boardVo) {
		boardDao.insert(boardVo);
	}

	@Override
	public BoardVo read(int seq) {
		return boardDao.select(seq);
	}
	
	
}
