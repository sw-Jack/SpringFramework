package spring;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RegisterRequestValidator implements Validator{

	private static final String EMAIL_REG_EXP = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9]+)*@" +
			"[A-Za-z0-9]+(\\.[_A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private Pattern pattern;
	
	public RegisterRequestValidator() {
		pattern = Pattern.compile(EMAIL_REG_EXP);
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//target : 검사 대상 객체 참조(커맨드 객체)
		//errors : target 검사 후 에러 코드를 저장하는 객체(스프링이 만들어서 전달해 준 것)
		RegisterRequest regReq = (RegisterRequest)target;
		
		//이메일 유효성 검증
		if(regReq.getEmail() == null || regReq.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");
		}else {
			Matcher matcher = pattern.matcher(regReq.getEmail());
			if(!matcher.matches()) {
				errors.rejectValue("email", "bad");
			}
		}
	}

}
