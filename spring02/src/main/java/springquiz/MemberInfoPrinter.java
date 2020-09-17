package springquiz;

public class MemberInfoPrinter {
	private MemberDao memberDao;
	private MemberPrinter memberPrinter;
	
	public MemberInfoPrinter(MemberDao memberDao, MemberPrinter memberPrinter) {
		this.memberDao = memberDao;
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
