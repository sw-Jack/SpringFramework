package springquiz;

import java.util.Collection;

public class MemberListPrinter {
	
	private MemberDao memberDao;
	private MemberPrinter memberPrinter;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void setMemberPrinter(MemberPrinter memberPrinter) {
		this.memberPrinter = memberPrinter;
	}

	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		for(Member m : members) {
			memberPrinter.print(m);
		}
	}
}
