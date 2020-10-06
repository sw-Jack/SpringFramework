package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.AlreadyExistingMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
public class RegisterController {
	
	@RequestMapping(value = "/register/step1", method = RequestMethod.GET)
	public String handleStep1() {
		return "register/step1";
	}
	
	@RequestMapping(value="/register/step2", method=RequestMethod.POST)
	public String hendleStep2(
			@RequestParam(value="agree", defaultValue="false") Boolean agree) {
		if(!agree) {
			return "register/step1";
		}
		return "register/step2";
	}
	
	@RequestMapping(value="/register/step2", method=RequestMethod.GET)
	public String hendleStep2() {
		return "redirect:/register/step1";
	}
	
	private MemberRegisterService memberRegSvc;
	
	public void setMemberRegisterService(MemberRegisterService service) {
		this.memberRegSvc = service;
	}
	
	// 커맨드 객체 활용
	@RequestMapping(value="/register/step3", method=RequestMethod.POST)
	public String handleStep3(RegisterRequest regReq) {
		try {
			memberRegSvc.regist(regReq);
			return "register/step3";
		}catch(AlreadyExistingMemberException e) {
			return "register/step2";
		}
	}
}
