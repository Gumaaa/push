package com.gm.home.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gm.home.util.Pager;

@Mapper
public interface QnaMapper {
	
	// 리스트
	public List<QnaVO> getList(Pager pager) throws Exception;
	
	// 글쓰기
	public QnaVO setWrite(QnaVO qnaVO) throws Exception;
}
