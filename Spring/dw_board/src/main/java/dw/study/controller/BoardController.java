package dw.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dw.study.domain.BoardVO;
import dw.study.domain.Criteria;
import dw.study.service.BoardService;

@Controller //bean으로 인식할 수 있게 함
@RequestMapping("/board/*") // /board로 시작하는 모든 처리를 할 수 있도록 지정
public class BoardController {
	private BoardService service;
	
	public BoardController(BoardService service) {
		this.service = service;
	}
	
	@GetMapping("/list")
//	public void list(Model model) {
//		System.out.println("list");
//		model.addAttribute("list", service.getList());
//	}
	public void list(Criteria cri, Model model) {
		System.out.println("list paging");
		model.addAttribute("list", service.getList(cri));
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) { //등록
		System.out.println("register");
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") int bno, Model model) {
		System.out.println("get or modify");
		model.addAttribute("board",service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		System.out.println("modify");
		service.update(board);
		rttr.addAttribute("result","success");
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(int bno, RedirectAttributes rttr) {
		System.out.println("remove");
		if(service.remove(bno))
			rttr.addAttribute("result","success");
		return "redirect:/board/list";
	}

}
