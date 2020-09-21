package spring2;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//DAO (Data Access Object) : DB 접근 클래스 
public class MemberDao {
	// 데이터베이스 역할
	private static long nextId = 0;
	private Map<String, Member> map = new HashMap<>(); 
	
	// 삽입 
	public void insert(Member member) {
		nextId++;
		member.setId(nextId);
		map.put(member.getEmail(), member);
	}
	
	// 조회
	public Member selectByEmail(String email) {
		Member result = map.get(email);
		return result;
	} 
	
	// 수정 (비밀번호 수정)
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
	
	// 삭제 (탈퇴)
	
	// 전체 조회
	public Collection<Member> selectAll() {
		return map.values();
	}
}




















