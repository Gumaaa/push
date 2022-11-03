package com.gm.home.board.qna;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class QnaVO {

	private Long num;
	@NotBlank(message = "필수항목입니다")
	private String title;
	@NotBlank
	private String writer;
	@NotBlank
	private String contents;
	private Long hit;
	private Date regDate;
	private Long ref;
	private Long step;
	private Long depth;
	
	private List<QnaFileVO> qnaFileVOs;
	private MultipartFile [] files;
}
