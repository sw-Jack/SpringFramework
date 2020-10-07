package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.AlreadyExistingMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.RegisterRequestValidator;

@Controller
public class RegisterController {
	
	private MemberRegisterService memberRegSvc;
	//name="memberRegisterService" => setMemberRegisterService
	public void setMemberRegisterService(MemberRegisterService service) {
		this.memberRegSvc = service;
	}
	
	@RequestMapping(value = "/register/step1", method = RequestMethod.GET)
	public String handleStep1() {
		return "register/step1";
	}
	
	@RequestMapping(value="/register/step2", method=RequestMethod.POST)
	public String hendleStep2(
			@RequestParam(value="agree", defaultValue="false") Boolean agree
			, Model model) {
		if(!agree) {
			return "redirect:/register/step1";
		}
		model.addAttribute("formData", new RegisterRequest());
		return "register/step2";
	}
	
	@RequestMapping(value="/register/step2", method=RequestMethod.GET)
	public String hendleStep2() {
		return "redirect:/register/step1";
	}
	
	//커맨드 객체 활용
	@RequestMapping(value="/register/step3", method=RequestMethod.POST)
	public String handleStep3(@ModelAttribute("formData") RegisterRequest regReq,
			Errors errors/*에러를 담기 위한 객체*/) {

		//커맨드 객체 검증 요청
		new RegisterRequestValidator().validate(regReq, errors);
		if(errors.hasErrors()) {
			System.out.println("이메일 문제있음");
			return "register/step2";
		}
		
		
		try {
			//dispatcher가 model에 커맨드객체의 클래스 이름을 첫글자만 소문자로 변경하여 모델에 등록함
			//model.addAttribute("registerRequest", regReq);
			
			//@ModelAttribute는 커맨드객체의 이름을 명시
			//model.addAttribute("formData", regReq);
			memberRegSvc.regist(regReq);
			return "register/step3";
		}catch(AlreadyExistingMemberException e) {
			return "register/step2";
		}
	}
}
