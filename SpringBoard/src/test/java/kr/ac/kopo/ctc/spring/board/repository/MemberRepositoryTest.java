package kr.ac.kopo.ctc.spring.board.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.ac.kopo.ctc.spring.board.domain.Member;
import kr.ac.kopo.ctc.spring.board.domain.Phone;

//import 기본적인걸로 하기, 어노테이션 잘 쓰기 

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {
	
	@Autowired 
	private MemberRepository memberRepository;
	
	   @Test
	   //선언적 트랜잭션
	   //쿼리문이 정상적으로 완료가 되고, 처리 도중 에러가 났을 때 처리한 쿼리를 자동 rollback 해주기 위해 사용된다.
	   @Transactional
	   public void oneToMany_TwoWay() {
	      Member first = new Member("Jung");
	      first.addPhone(new Phone("010-xxxx-xxxx"));
	      first.addPhone(new Phone("010-yyyy-yyyy"));
	      
	      Member second = new Member("Dong");
	      second.addPhone(new Phone("010-zzzz-zzzz"));
	      
	      Member third = new Member("Min");
	      
	      memberRepository.save(first);
	      memberRepository.save(second);
	      memberRepository.save(third);
	      
	      //모든 엔티티를 취득 
	      List<Member> list = memberRepository.findAll();
	      
	      for( Member m : list ) {
	         System.out.println(m.toString());
	      }
	      memberRepository.deleteAll();
		

	}
}
