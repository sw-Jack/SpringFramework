package spring3;

import javax.annotation.Resource;

public class MemberInfoPrinter {
	
	private MemberDao memberDao;
	private MemberPrinter memberPrinter;
	
	@Resource(name="memberDao1")
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Resource(name="memberPrinter1")
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
