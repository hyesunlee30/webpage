package kr.ac.kopo.ctc.spring.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.Phone;

//Repository는 domain을 받아온다.
//service는 없어도 에러가 나지 않는다. 
//Phone 도메인을 가져다 쓴다. 
//JpaRepository에는 select, all 등의 함수가 구현되어 있음
@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {

}
