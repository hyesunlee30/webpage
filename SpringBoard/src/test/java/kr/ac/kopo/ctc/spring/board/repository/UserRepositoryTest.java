package kr.ac.kopo.ctc.spring.board.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import kr.ac.kopo.ctc.spring.board.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest

//import 기본적인걸로 하기, 어노테이션 잘 쓰기 



public class UserRepositoryTest {
	
	@Autowired 
	private UserRepository userRepository;
		
	@Test
	@Transactional
	public void oneToMany_TwoWay() {
		
		
//		String today ="";
//				
//		Calendar caL = Calendar.getInstance(); // 날짜 가져오기 
//		SimpleDateFormat sdt = new SimpleDateFormat("YYYY-MM-dd"); // 날짜 시간 포맷 
//		today = sdt.format(caL.getTime());
		
		//게시글 두 개
		User first = new User("Lee");
		//first.addGongjis(new Gongji1("Lee","title1",today,"내용"));
		//first.addGongjis(new Gongji1("Lee","title2",today,"내용입니다"));
		
		//게시글 한 개
		User second = new User("Ha");
		//second.addGongjis(new Gongji1("Ha","title",today,"내용이에요"));
		
		//게시글 없음
		User third = new User("Jang");
		
		userRepository.save(first);
		userRepository.save(second);
		userRepository.save(third);
		
		List<User> list = userRepository.findAll();
		
		for( User u : list ) {
			System.out.println(u.toString());
		}
		
		userRepository.deleteAll();
	
	}

}



