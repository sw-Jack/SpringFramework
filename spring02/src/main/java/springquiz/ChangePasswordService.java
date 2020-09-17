package springquiz;

public class ChangePasswordService {
	// Service Page -> 항상 Dao 참조하고,
	private MemberDao memberDao;
	// 생성자 생성
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);
		
	}
}
