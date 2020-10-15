package board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import board.domain.BoardVo;
import board.service.BoardService;

@Controller
@SessionAttributes("boardVo")
/*
 * Model에 boardVo라는 이름의 객체가 등록되면 세션에도 저장되도록 한다.
 */
public class BoardController {

	@Autowired
	private BoardService boardService;
		
//	public void setBoardService(BoardService boardService) {
//		this.boardService = boardService;
//	}
	
//	@RequestMapping(value="/board/list")
//	@ResponseBody
//	public String list() {
//		return boardService.list().toString();
//	}
	
	@RequestMapping(value="/board/list")
	public String list(Model model) {
		model.addAttribute("boardList", boardService.list());
		return "/board/list";
	}
	
	//읽기
	@RequestMapping(value="/board/read/{seq}")
	public String read(Model model, @PathVariable int seq) {
		model.addAttribute("boardVo", boardService.read(seq));
		return "/board/read";
	}
	
	//새글
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("boardVo", new BoardVo());
		/*
		 * BoardVo객체를 생성하여 모델에 추가. 객체가 없을 때 문제 발생 해결
		 */
		return "/board/write";
	}
	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	public String write(@Valid BoardVo boardVo, BindingResult bindingResult) {
		/*
		 * BindingResult 객체를 인자로 전달 받음.
		 * 요청정보에 검증결과 에러가 있을 경우 hasErrors로 확인 가능 
		 */
		if(bindingResult.hasErrors()) {
			System.out.println("test");
			return "/board/write";
		}
		boardService.write(boardVo);
		return "redirect:/board/list";
		/*
		 * post로 요청 시 처리 결과를 리다이렉트하여 get요청을 하도록 하는 형태(Post-Redirect-Get 패턴)
		 */
	}
	
	//수정
	@RequestMapping(value="/board/edit/{seq}", method=RequestMethod.GET)
	public String edit(@PathVariable int seq, Model model) {
		BoardVo boardVo = boardService.read(seq);
		System.out.println("GET:" + boardVo);
		model.addAttribute("boardVo", boardVo);
		/*
		 * @SessionAttributes("boardVo") 이 설정을 통해 세션에도 객체가 저장됨 
		 */
		return "/board/edit";
	}
	
	//수정
	@RequestMapping(value="/board/edit/{seq}", method=RequestMethod.POST)
	public String edit(
			@PathVariable int seq, 
			Model model,
			@Valid BoardVo boardVo,	
			BindingResult bindingResult,
			int pwd,
			SessionStatus sessionStatus/* 세션에 대한 처리 가능 */) {
		System.out.println("POST:" + boardVo);
		System.out.println("pwd:" + pwd);
		if(bindingResult.hasErrors()) {
			return "/board/edit";
		}else {
			if(boardVo.getPassword() == pwd) {
				boardService.edit(boardVo);
				sessionStatus.setComplete();//세션에 저장된 객체를 제거(옵션)
				return "redirect:/board/list";
			}
		}
		model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
		return "/board/edit";
	}
	
	//삭제
	@RequestMapping(value="/board/delete/{seq}", method=RequestMethod.GET)
	public String delete(@PathVariable int seq, Model model) {
		model.addAttribute("seq", seq);
		return "/board/delete";
	}
	
	@RequestMapping(value="/board/delete", method=RequestMethod.POST)
	public String delete(int seq, int pwd, Model model) {
		int rowCount;
		BoardVo boardVo = new BoardVo();
		boardVo.setSeq(seq);
		boardVo.setPassword(pwd);
		
		rowCount = boardService.delete(boardVo);
		if(rowCount == 0) {
			model.addAttribute("seq", seq);
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
			return "/board/delete";
		}else {
			return "redirect:/board/list";
		}
	}
}
