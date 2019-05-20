package kr.ac.kopo.ctc.spring.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.Member;

//실제로 Member Entity를 이용하기 위한 Repository클래스
//기본적인 메소드 외에도 추가할 수 있다. 메소드 이름을 기반으로 해서 만들어도 되고 
//@Query를 이용해 기존의 SQL처럼 만들어도 됩니다. 
//findByNameAndAgeLessThan 메소드와 findByNameAndAgeLessThanSQL 메소드는 
//같은 결과를 출력하지만 전자의 메소드는 메소드 이름을 기반으로 한것이고
//후자의 메소드는 @Query 어노테이션을 기반으로 해서 만든것입니다.
//메소드 이름 기반으로 해서 만들면 추후에 사용할 때 메소드 이름만으로도 어떤 쿼리인지 알 수 있다는 장점이 있습니다.
//반대로 @Query 어노테이션으로 만든 메소드는 기존의 소스를 컨버팅하는 경우 유용하게 사용할 수  있다
//다만 @Query 어노테이션으로 쿼리를 만들 때에 from 절에 들어가는 테이블은 Entity로 지정된 클래스명입니다. 
//바로 Member입니다. 그리고 where절에서는 Member 클래스 내의 멤버 변수를 통해 조건을 걸 수 있습니다.

//controller, service, repository - component 상속받게 되어 있다. 
//해당 어플리케이션에서 딱 하나만 생기는 싱글톤!! 
//제네릭으로 2개의 형을 지정한다 첫번째는 DAO가 취급하는 ENtity 클래스형, 두 번째는 Entity 클래스의 ID형입니다.
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{

	List<Member> findByNameAndAgeLessThan(String name, int age);

	@Query("select t from Member t where name=:name and age < :age")
	List<Member> findByNameAndAgeLessThanSQL(@Param("name") String name, @Param("age") int age);
	
	List<Member> findByNameAndAgeLessThanOrderByAgeDesc(String name, int age);
	
}
