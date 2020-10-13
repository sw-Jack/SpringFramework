package spring;

import org.mybatis.spring.SqlSessionTemplate;

public class MemberDaoImpl implements MemberDao{
	
	private SqlSessionTemplate sqlSessionTemplate;

	public MemberDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public void insert(Member member) {
		sqlSessionTemplate.insert("memberDao.insert", member);
	}

	@Override
	public Member selectByEmail(String email) {
		return sqlSessionTemplate.selectOne("memberDao.selectByEmail", email);
	}

	@Override
	public void update(Member member) {
		sqlSessionTemplate.update("memberDao.update", member);
	}
	
}
