package spring;

public interface MemberDao {
	
	//삽입
	public void insert(Member member);

	//RowMapper 중복코드 처리 후
	public Member selectByEmail(String email);
	
	//수정(비밀번호 수정)
	public void update(Member member);
		
	//삭제(탈퇴)
	
	//전체 조회(RowMapper 중복코드 처리 전)
}
