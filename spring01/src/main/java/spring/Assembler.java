package spring;

/*
 * 조립기
 * - 객체를 생성하고 의존 객체를 주입하는 기능 (Dependency Injection)
 * - 특정 객체를 필요로 하는 곳에 객체를 제공할 수 있음
 */
public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);	// 의존성 주입
		pwdSvc = new ChangePasswordService(memberDao); 	// 의존성 주입 
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}

	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}
	
	
}
