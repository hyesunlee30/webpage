package kr.ac.kopo.ctc.spring.board.repository;


import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.Gongji1;

@Repository("Gongji1Repository")
public interface Gongji1Repository extends JpaRepository<Gongji1, Integer>{
	

 
	Page<Gongji1> findAll(Pageable pageRequest);
	Page<Gongji1> findAllByOrderByIdDesc(Pageable pageRequest);
	Page<Gongji1> findAllByAuthorContaining(String author,Pageable pageRequest);
	Page<Gongji1> findAllByTitleContaining(String title,Pageable pageRequest);
	//Page<Gongji1> findByTitleContainingOrContentContaining(String title, String searchString, Pageable pageRequest);


	@Query("select t from Gongji1 t where content like concat('%', :searchString, '%')")
	Page<Gongji1> findAllSearch(@Param("searchString") String searchString, Pageable pageable);


}
