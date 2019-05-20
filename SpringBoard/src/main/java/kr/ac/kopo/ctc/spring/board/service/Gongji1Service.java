package kr.ac.kopo.ctc.spring.board.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kr.ac.kopo.ctc.spring.board.domain.Gongji1;
import kr.ac.kopo.ctc.spring.board.dto.Gongji1Dto;
import kr.ac.kopo.ctc.spring.board.repository.Gongji1Repository;

public interface Gongji1Service {




	// 게시판 리스트
	public List<Gongji1> findAll(int page);

	//페이지

	
	
}
