package kr.ac.kopo.ctc.spring.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.Sample;



//controller, service, repository - component 상속받게 되어 있다. 해당 어플리케이션에서 딱 하나만 생기는 싱글톤!! 
@Repository
public interface SampleRepository extends JpaRepository<Sample, Long>{

	//home 글자가 포함되어 있는 모든 sample
	List<Sample> findAllByTitleLike(String title);
	//level > 5 이상의 모든 sample
	List<Sample> findAllByLevelGreaterThan(int level);


	
}
