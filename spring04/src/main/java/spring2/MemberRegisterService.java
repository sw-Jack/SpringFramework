package spring2;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
// 회원 가입 처리
public class MemberRegisterService {
	
	// JavaConfig를 사용할 경우 @Autowired는 생성자에 선언 불가
	// 스프링에서 Java 설정 파일에 Bean 생성 시 호출되는 생서자를 선택할 수 없다.
	private MemberDao memberDao;	
	

	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
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
