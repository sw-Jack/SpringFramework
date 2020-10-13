package spring;

import java.util.Date;

public class MemberRegisterService {
	private MemberDao memberDao;	//Dao를 참조
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
		System.out.println("MemberRegisterService 생성");
	}
	
	//회원 가입 기능
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
