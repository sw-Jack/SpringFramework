package spring;

import java.util.Date;

public class MemberRegisterService {
	private MemberDao memberDao;		// Dao 참조
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	

	// 회원가입 기능
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
