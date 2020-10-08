package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.AuthInfo;
import spring.AuthService;
import spring.IdPasswordNotMatchingException;
import spring.LoginCommand;
import spring.LoginCommandValidator;

@Controller
@RequestMapping("/login") // 기본 경로 설정
public class LoginController {
   
   private AuthService authService;
   
   public void setAuthService(AuthService authService) {
      this.authService = authService;
   }
   
   @RequestMapping(method=RequestMethod.GET)
   public String form(LoginCommand loginCommand) {
      return "login/loginForm";
   }
   
   @RequestMapping(method=RequestMethod.POST)
   public String submit(LoginCommand loginCommand, Errors errors, HttpSession session) {
      new LoginCommandValidator().validate(loginCommand, errors);
      if(errors.hasErrors()) {
         return "login/loginForm";
      }
      try {
         AuthInfo authInfo = authService.authentication(
               loginCommand.getEmail(), 
               loginCommand.getPassword());
         session.setAttribute("authInfo", authInfo);	// 인증정보 세션에 저장
         return "login/loginSuccess";
         
      }catch(IdPasswordNotMatchingException e) {
         errors.reject("idPasswordNotMatching");
         return "login/loginForm";
      }
   }
   
   
}