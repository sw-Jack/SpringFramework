package spring;
import java.util.*;

// 회원 관리 프로그램
public class Main {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		Member m1 = new Member("a@naver.com", "1234","홍길동",new Date());
		Member m2 = new Member("b@naver.com", "1234","이순신",new Date());
		Member m3 = new Member("c@naver.com", "1234","강감찬",new Date());

		// 회원 등록
		dao.insert(m1);
		dao.insert(m2);
		dao.insert(m3);
		
		// 회원 조회 (email 조회)
		System.out.println(dao.selectByEmail("b@naver.com"));
		System.out.println(dao.selectByEmail("D@naver.com"));
		System.out.println(dao.selectByEmail("a@naver.com"));
		System.out.println(dao.selectByEmail("c@naver.com"));
		
	}

}
