package com.gm.home.board.qna;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class QnaVO {

	private Long num;
	@NotBlank
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
}
