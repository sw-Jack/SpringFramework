package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.AuthInfo;
import spring.AuthService;
import spring.IdPasswordNotMatchingException;
import spring.LoginCommand;
import spring.LoginCommandValidator;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private AuthService authService;
	
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String form(
			@ModelAttribute("command") LoginCommand loginCommand,
			@CookieValue(value="REMEMBER", required=false)Cookie cookie,
			HttpSession session) {
//		session.setMaxInactiveInterval(초단위);
		//@CookieValue(value="REMEMBER", required=false)Cookie cookie
		//요청에서 쿠키를 확인하기 위한 방법
		if(cookie != null) {
			loginCommand.setEmail(cookie.getValue());
			loginCommand.setRememberEmail(true);
		}
		return "login/loginForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(
			@ModelAttribute("command") LoginCommand loginCommand, 
			Errors errors, HttpSession session,
			HttpServletResponse response) {
		new LoginCommandValidator().validate(loginCommand, errors);
		if(errors.hasErrors()) {
			return "login/loginForm";
		}
		try {
			AuthInfo authInfo = authService.authentication(
					loginCommand.getEmail(), 
					loginCommand.getPassword());
			session.setAttribute("authInfo", authInfo);//인증정보 세션에 저장
			
			//쿠키를 생성
			Cookie rememberCookie = 
					new Cookie("REMEMBER", loginCommand.getEmail());
			rememberCookie.setPath("/");
			
			//아이디 기억하기 체크 여부 확인
			if(loginCommand.isRememberEmail()) {
				rememberCookie.setMaxAge(60*60*24*30);
			}else {
				rememberCookie.setMaxAge(0);
			}
			
			//응답에 쿠키 추가
			response.addCookie(rememberCookie);
			
			return "login/loginSuccess";
			
		}catch(IdPasswordNotMatchingException e) {
			errors.reject("idPasswordNotMatching");
			errors.reject("required");
			return "login/loginForm";
		}
	}
	
	
}
