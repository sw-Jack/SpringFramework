package board.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.domain.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
//	public BoardDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
//		this.sqlSessionTemplate = sqlSessionTemplate;
//	}
	
	@Override
	public List<BoardVo> list() {
		return sqlSessionTemplate.selectList("list");
	}

	@Override
	public int delete(BoardVo boardVo) {
		return sqlSessionTemplate.delete("boardDao.delete", boardVo);
	}

	@Override
	public int update(BoardVo boardVo) {
		return sqlSessionTemplate.update("boardDao.update", boardVo);
	}

	@Override
	public void insert(BoardVo boardVo) {
		sqlSessionTemplate.insert("boardDao.insert", boardVo);
	}

	@Override
	public BoardVo select(int seq) {
		return sqlSessionTemplate.selectOne("select", seq);
	}

	@Override
	public int updateReadCount(int seq) {
		return sqlSessionTemplate.update("updateCount", seq);
	}

}
