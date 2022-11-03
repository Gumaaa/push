package com.gm.home.file;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.gm.home.board.qna.QnaFileVO;
import com.gm.home.board.qna.QnaService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileController {
	
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("/fileDown/{p}")
	public ModelAndView fileDownload(@PathVariable(name = "p") String path, QnaFileVO qnaFileVO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		if(path.equals("qna")) {
			qnaFileVO = qnaService.getFileDetail(qnaFileVO);
		} else {
			log.info("뭔가 이상한데?");
		}
		
		mv.addObject("FileVO", qnaFileVO);
		mv.addObject("path", path);
		
		mv.setViewName("fileManager");
		
		return mv;
	}
}
