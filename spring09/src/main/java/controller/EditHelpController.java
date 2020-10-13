package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditHelpController {
	@RequestMapping("/edit/help/test")
//	@RequestMapping("/edit/test")
	public ModelAndView help(ModelAndView mav) {
		mav.addObject("result", 100);
		mav.setViewName("edit/help/test");
		return mav;
	}
	
	//비동기 통신에 활용되는 형태(jsp파일이 아니라 문자열 데이터 자체를 반환)
	@RequestMapping("/edit/help/restapi")
	@ResponseBody
	public String rest() {
		//처리 코드~
		return "<h1>result</h1>";	//일반적으로 json형식
	}
}
