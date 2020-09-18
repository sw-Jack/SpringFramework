package spring;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
// 회원 가입 처리
public class MemberRegisterService {
	// Service Page -> 항상 Dao 참조하고,
	private MemberDao memberDao;		// Dao 참조
	
	// 생성자 생성
	@Autowired
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	

	// 회원가입 기능  // req -> 새로 회원가입하는 사람들의 정보
	public void regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			throw new AlreadyExistingMemberException(
					"dup email " + req.getEmail());
		}
		Member newMember = new Member(
				req.getEmail(),
				req.getPassword(),
				req.getName(),
				new Date()
				);
		memberDao.insert(newMember);
	}
	
}
