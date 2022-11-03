package com.gm.home.board.qna;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gm.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/qna/*")
@Slf4j
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	// 리스트
	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		List<QnaVO> ar = qnaService.getList(pager);
		
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	// 글쓰기 + 첨부파일
	// @ModelAttribute : 입력폼이 있는 JSP로 이동 전 Controller에서 Data가 없는 빈 VO객체를 Model 담아서 전송
	@GetMapping("write")
	public String setWrite(@ModelAttribute QnaVO qnaVO) throws Exception {
		
		return "board/write";
	}
	
	@PostMapping("write")
	public ModelAndView setWrite(@Valid QnaVO qnaVO, BindingResult bindingResult, ModelAndView mv, RedirectAttributes redirectAttributes) throws Exception {
		
		if(bindingResult.hasErrors()) {
			log.info("QNA WRITE ERROR");
			mv.setViewName("board/write");
			
			return mv;
		}
		
		int result = qnaService.setWrite(qnaVO);
		redirectAttributes.addAttribute("result", result);
		
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView getDetail(QnaVO qnaVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		qnaVO = qnaService.getDetail(qnaVO);
		
		mv.addObject("detail", qnaVO);
		mv.setViewName("board/detail");
		
		return mv;
	}
}
