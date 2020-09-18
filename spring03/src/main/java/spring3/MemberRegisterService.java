package spring3;

import java.util.Date;

import javax.annotation.Resource;

public class MemberRegisterService {
	@Resource(name="memberDao1")
	private MemberDao memberDao;	
	
	// @Resource는 생성자 적용 불가
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	// @Resource 위해 디폴트 생성자 생성
	public MemberRegisterService() {
		
	}

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
