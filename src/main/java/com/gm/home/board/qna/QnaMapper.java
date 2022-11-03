package com.gm.home.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gm.home.util.Pager;

@Mapper
public interface QnaMapper {
	
	// 리스트
	public List<QnaVO> getList(Pager pager) throws Exception;
	
	// 글쓰기
	public int setWrite(QnaVO qnaVO) throws Exception;
	
	// 첨부파일
	public int setAddFile(QnaFileVO qnaFileVO) throws Exception;
	
	// 상세보기
	public QnaVO getDetail(QnaVO qnaVO) throws Exception;
	
	// 파일 컨트롤러에서 사용할 파일정보
	public QnaFileVO getFileDetail(QnaFileVO qnaFileVO) throws Exception;
}
