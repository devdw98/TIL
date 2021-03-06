package org.dw0119.controller;

import org.dw0119.domain.BoardVO;
import org.dw0119.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());
	}
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register"+board);
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno()); //일회성으로만 데이터를 전달하여 도배를 막을 수 있음
		return "redirect:/board/list"; //spring mvc가 내부적으로 response.sendRedirect() 처리를 해줌
	}
	
	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("/get");
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify: "+board);
		
		if(service.modify(board))
			rttr.addFlashAttribute("result", "success");
		return "redirect: /board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("remove .."+bno);
		if(service.delete(bno)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect: /board/list";
	}
	
}
