package spring;

public class MemberInfoPrinter {
	private MemberDao memberDao;
	
	private MemberPrinter memberPrinter;
	
	public void setMemberDao(MemberDao memberDao) {
		System.out.println("setter");
		this.memberDao = memberDao;
	}
	
	public void setMemberPrinter(MemberPrinter memberPrinter) {
		this.memberPrinter = memberPrinter;
	}
	
	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			System.out.println("회원 정보 없음");
			return;
		}
		memberPrinter.print(member);
	}
}
