package kr.ac.kopo.ctc.spring.board.service;

import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.spring.board.domain.Gongji1;
import kr.ac.kopo.ctc.spring.board.dto.Gongji1Dto;
import kr.ac.kopo.ctc.spring.board.repository.Gongji1Repository;

//Service 객체선언
@Service("gongji1Service")
public class Gongji1ServiceImple implements Gongji1Service {

	Logger log = Logger.getLogger(this.getClass());
	
	
	//DAO
	@Autowired
	private Gongji1Repository gongji1Repository;
	

	@Override
	public List<Gongji1> findAll(int page) {
		return gongji1Repository.findAll();
	}



}
