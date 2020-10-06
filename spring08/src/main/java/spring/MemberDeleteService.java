package spring;

public class MemberDeleteService {
	private MemberDao memberDao;
	
	public MemberDeleteService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void memberDeleteService(String email, String password) {
		Member curMember = memberDao.selectByEmail(email);
		if(curMember == null) {
			throw new MemberNotFoundException();
		}else if(!curMember.getPassword().equals(password)){
			throw new IdPasswordNotMatchingException();
		}
		memberDao.delete(email, password);
	}
}
