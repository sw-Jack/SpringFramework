package main;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.AlreadyExistingMemberException;
import spring.ChangePasswordService;
import spring.IdPasswordNotMatchingException;
import spring.MemberDeleteService;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.VersionPrinter;

public class MainForSpring {
	
	private static GenericXmlApplicationContext ctx = null;
	
	public static void main(String[] args) {
		
		ctx = new GenericXmlApplicationContext("classpath:appctx.xml");
		
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.print("명령어를 입력하세요:");
			String command = in.nextLine();
			if(command.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			if(command.startsWith("new")) {
				processNewCommand(command.split(" "));
				continue;
			}else if(command.startsWith("change")) {
				processChangeCommand(command.split(" "));
				continue;
			}else if(command.equals("list")){
				processListCommand();
				continue;
			}else if(command.startsWith("info")){
				processInfoCommand(command.split(" "));
				continue;
			}else if(command.startsWith("delete")){ //이메일/비밀번호를 이용하여 회원 삭제
				processDeleteCommand(command.split(" "));
				continue;
			}else if(command.equals("version")){
				processVersionCommand();
				continue;
			}else {	
				printHelp();
			}
		}
	}

	private static void processDeleteCommand(String[] args) {
		//이메일/비밀번호를 이용하여 회원 삭제
		if(args.length != 3) {
			return;
		}
		MemberDeleteService memberDelSvc = 
				ctx.getBean("memberDelSvc", MemberDeleteService.class);
		try {
			memberDelSvc.memberDeleteService(args[1], args[2]);
			System.out.println(args[1] + "회원이 삭제되었습니다.");
		}catch(MemberNotFoundException e) {
			System.out.println("회원 정보가 존재하지 않습니다.");
		}catch(IdPasswordNotMatchingException e) {
			System.out.println("비밀번호가 맞지 않습니다.");
		}
		
	}


	private static void processVersionCommand() {
		VersionPrinter versionPrinter = 
				ctx.getBean("versionPrinter", VersionPrinter.class);
		versionPrinter.print();
	}


	private static void processInfoCommand(String[] args) {
		if(args.length != 2) {
			printHelp();
			return;
		}
		MemberInfoPrinter memberInfoPrinter = 
				ctx.getBean("memberInfoPrinter", MemberInfoPrinter.class);
		memberInfoPrinter.printMemberInfo(args[1]);
	}


	private static void processListCommand() {
		MemberListPrinter memberListPrinter = 
				ctx.getBean("memberListPrinter", MemberListPrinter.class);
		memberListPrinter.printAll();
	}


	private static void processNewCommand(String[] args) {
		if(args.length != 5) {
			printHelp();
			return;
		}
		MemberRegisterService regSvc = 
				ctx.getBean("memberRegSvc", MemberRegisterService.class);
		RegisterRequest req = new RegisterRequest();
		req.setEmail(args[1]);
		req.setName(args[2]);
		req.setPassword(args[3]);
		req.setConfirmPassword(args[4]);
		
		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호와 확인이 일치하지 않습니다.");
			return;
		}
		try {
			regSvc.regist(req);
			System.out.println("등록되었습니다.");
		}catch(AlreadyExistingMemberException e) {
			System.out.println("이미 존재하는 이메일입니다.");
		}
	}

	private static void processChangeCommand(String[] args) {
		if(args.length != 4) {
			printHelp();
			return;
		}
		ChangePasswordService changePwdSvc = 
				ctx.getBean("changePwdSvc", ChangePasswordService.class);
		try {
			changePwdSvc.changePassword(args[1], args[2], args[3]);
			System.out.println("암호가 변경되었습니다.");
		}catch(MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일입니다.");
		}catch(IdPasswordNotMatchingException e) {
			System.out.println("이메일과 암호가 일치하지 않습니다.");
		}
	}
	
	private static void printHelp() {
		System.out.println("사용법:");
		System.out.println("list");
		System.out.println("info [이메일]");
		System.out.println("new [이메일] [이름] [암호] [암호확인]");
		System.out.println("change [이메일] [현재비밀번호] [변경할비밀번호]");
		System.out.println("delete [이메일] [비밀번호]");
		System.out.println("version");
	}
}
