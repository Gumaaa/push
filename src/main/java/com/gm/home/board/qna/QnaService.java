package com.gm.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gm.home.util.Pager;

@Service
public class QnaService {
	
	@Autowired
	private QnaMapper qnaMapper;
	
	// 리스트
	public List<QnaVO> getList(Pager pager) throws Exception {
		pager.getRowNum();
		
		return qnaMapper.getList(pager);	
	}
	
	// 글쓰기
	public QnaVO setWrite(QnaVO qnaVO) throws Exception {
		
		return qnaMapper.setWrite(qnaVO);
	}
}
