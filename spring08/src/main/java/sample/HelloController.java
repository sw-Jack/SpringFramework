package sample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	public static int factorial(int n) {
		if(n <= 1 ) return 1;
		else return factorial(n-1) * n;
	}
	
	@RequestMapping("/")
	public String main(/* 필요한 매개변수 (스프링이 알아서 자동으로 넣어줌 */) {
		//처리~DB~등등~비즈니스로직~
		//model 에 결과값 담기, 담을 거 없으면 빈 채로 
		return "main";
	}
	// ... /hello 라고 URL 요청을 받았을 때
	@RequestMapping("/hello")
	// Model 객체 model 자동 생성, name은 이후 URL의 param
	public String hello(Model model, String name) {
		model.addAttribute("greeting", "안녕하세요, " + name + "님!");
		// 이후 dispatcher 서블릿이 반환된 hello를 처리
		// 아래 반환값은 spring-mvc.xml 파일로 전달, prefix/suffix 경로에 편입되어
		// 찾을 파일을 검색
		// /WEB-INF/view/"hello".jsp 가 되는 것
		return "hello";
	}
	
	@RequestMapping("/add")
	// URL의 param 값과 코드 내 변수를 다르게 쓸 경우 치환도 가능함
	public String add(
			Model model, 
			// URL에서 입력은 n1, n2 를 이용해 받겠다. 코드 내에선 num1, num2 변수 사용
			@RequestParam(value = "n1") int num1,
			@RequestParam(value = "n2") int num2) {
		int sum = num1 + num2;
		model.addAttribute("sum", sum);
		model.addAttribute("n1", num1);
		model.addAttribute("n2", num2);

		return "add";
	}
	
	@RequestMapping("/factorial")
	public String factorial(Model model, int n) {
		model.addAttribute("num", n);
		model.addAttribute("fact", factorial(n));
		return "factorial";
	}
	
	@RequestMapping("/ex")
	public String factorial(Model model, String ex1, String ex2) {
		model.addAttribute("ex1", ex1);
		model.addAttribute("ex2", ex2);

		return "ex";
	}

}
