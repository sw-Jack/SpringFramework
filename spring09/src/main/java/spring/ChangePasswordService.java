package spring;

import org.springframework.transaction.annotation.Transactional;

public class ChangePasswordService {
	private MemberDao memberDao;
	
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Transactional	//트랜잭션이 적용될 메서드
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		
		if(member == null) {
			throw new MemberNotFoundException();
		}
		//memberDao.update2(member);	//기존 회원의 이름을 변경하고 데이터베이스에 반영
		//member = memberDao.selectByEmail(member.getEmail()); //이름이 변경된 회원 정보 가져오기
		member.changePassword(oldPwd, newPwd);	//가져온 회원의 비밀번호를 변경하고
		memberDao.update(member);	//데이터베이스에 변경된 정보 반영
	}
}
