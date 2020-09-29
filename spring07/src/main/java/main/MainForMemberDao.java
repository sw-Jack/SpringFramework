package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.Member;
import spring.MemberDao;

public class MainForMemberDao {
   private static MemberDao memberDao;
   static Scanner in = new Scanner(System.in);
   public static void main(String[] args) {
      GenericXmlApplicationContext ctx = 
            new GenericXmlApplicationContext("classpath:appctx.xml");
      
      memberDao = ctx.getBean("memberDao", MemberDao.class);
      
      selectByEmail("test@naver.com");
      selectAll();
      count();
      //update();
      //insert();
      //delete();
      //selectAll();
      //count();
   }
   
   private static void delete() {
	   /*System.out.println("-----delete Test");
	   Member member = memberDao.selectByEmail("test@naver.com");
	   String storedPwd = member.getPassword();
	   System.out.print("비밀번호 입력 : ");
	   String confPwd = in.nextLine();
	   if(storedPwd.equals(confPwd)) memberDao.delete(member);
	   else System.out.println("오류");*/
	   System.out.println("-----delete Test");
	   Member member = new Member(
			   "0928185657@test.com",
			   "0928185657",
			   "name",
			   new Date());
	   memberDao.delete(member);
			  
   }
   
   private static void insert() {
	   System.out.println("-----insert Test");
	   SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
	   String prefix = dateFormat.format(new Date());
	   Member member = new Member(
			   prefix + "@test.com",
			   prefix, 
			   prefix,
			   new Date());
	   memberDao.insert(member);
	   System.out.println(member.getId() + "번  데이터 추가");
   }
   
   private static void update() {
	   System.out.println("-----update Test");
	   Member member = memberDao.selectByEmail("test@naver.com");
	   String oldPwd = member.getPassword();
	   String newPwd = Double.toHexString(Math.random());
	   member.changePassword(oldPwd, newPwd);
	   
	   memberDao.update(member);
	   System.out.println("암호 변경 : " + oldPwd + " -> " + newPwd);
   }
   
   private static void count() {
	   int cnt = memberDao.count();
	   System.out.println("멤버수 : " + cnt);
   }
   
   private static void selectAll() {
	   System.out.println("-----selectAll Test");
	   List<Member> lm = memberDao.selectAll();
	   for(Member tmp : lm) {
		   System.out.println(tmp);
	   }
   }
   private static void selectByEmail(String email) {
      System.out.println("-----selectByEmail Test");
      Member member = memberDao.selectByEmail(email);
      System.out.println(member);
   }
}