package com.gm.home.board.qna;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gm.home.util.FileManager;
import com.gm.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QnaService {
	
	@Autowired
	private QnaMapper qnaMapper;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${push.upload.qna}")
	private String path;
	
	// 리스트
	public List<QnaVO> getList(Pager pager) throws Exception {
		pager.getRowNum();
		
		return qnaMapper.getList(pager);	
	}
	
	// 글쓰기 + 첨부파일
	public int setWrite(QnaVO qnaVO) throws Exception {
		
		int result = qnaMapper.setWrite(qnaVO);
		
		File file = new File(path);
		
		// 만약 파일경로가 존재하지 않으면
		// exists : 존재
		if(!file.exists()) {
			boolean check = file.mkdir();
			log.info("File Check : {}", check);
		}
		
		for(MultipartFile f : qnaVO.getFiles()) {
			if(!f.isEmpty()) {
				
				log.info("Filename : {}", f.getOriginalFilename());
				String fileName = fileManager.saveFile(f, path);
				
				QnaFileVO qnaFileVO = new QnaFileVO();
				
				qnaFileVO.setFileName(fileName);
				qnaFileVO.setOriName(f.getOriginalFilename());
				qnaFileVO.setNum(qnaVO.getNum());
				
				qnaMapper.setAddFile(qnaFileVO);
			}
		}
		
		return result;
	}
	
	// 상세보기
	public QnaVO getDetail(QnaVO qnaVO) throws Exception {
		
		return qnaMapper.getDetail(qnaVO);
	}
	
	public QnaFileVO getFileDetail(QnaFileVO qnaFileVO) throws Exception {
		
		return qnaMapper.getFileDetail(qnaFileVO);
	}
	
}
