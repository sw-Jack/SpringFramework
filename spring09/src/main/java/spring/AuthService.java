package spring;

public class AuthService {
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public AuthInfo authentication(String email, String password) {
		System.out.println(memberDao);
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			throw new IdPasswordNotMatchingException();
		}
		if(!member.matchPassword(password)) {
			throw new IdPasswordNotMatchingException();
		}
		return new AuthInfo(member.getId(), member.getEmail(), member.getName());
	}
}
