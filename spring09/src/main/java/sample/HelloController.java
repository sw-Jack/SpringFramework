package sample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@RequestMapping("/")
	public String main(/*필요한 매개변수(스프링이 알아서 넣어줌)*/) {
		//처리~DB~등등~비즈니스 로직~
		//model에 결과값 담기
		return "main";	//jsp파일 선택
	}
	
	@RequestMapping("/hello")
	public String hello(Model model, @RequestParam(value="name", required = false) String name) {
		model.addAttribute("greeting", "안녕하세요, " + name + "님!");
		return "hello";
	}
	
	@RequestMapping("/add")
	public String add(
			Model model, 
			@RequestParam(value = "n1") int num1, 
			@RequestParam(value = "n2", required=false, defaultValue = "0") int num2) {
		System.out.println("add시작!");
		int sum = num1 + num2;
		model.addAttribute("sum", sum);
		model.addAttribute("n1", num1);
		model.addAttribute("n2", num2);
		return "add";
	}
}
