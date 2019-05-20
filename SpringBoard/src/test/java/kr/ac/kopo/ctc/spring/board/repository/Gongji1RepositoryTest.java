package kr.ac.kopo.ctc.spring.board.repository;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import kr.ac.kopo.ctc.spring.board.domain.Gongji1;
import kr.ac.kopo.ctc.spring.board.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Gongji1RepositoryTest {
	
	//먼저 Repository 들을 연결해야한다.
	@Autowired
	private Gongji1Repository gongji1Repository;
	
	@Autowired
	private UserRepository userRepository;

	@Test
	@Transactional
	public void oneToMany_OneWay() {

		String today ="";
		
		Calendar caL = Calendar.getInstance(); // 날짜 가져오기 
		SimpleDateFormat sdt = new SimpleDateFormat("YYYY-MM-dd"); // 날짜 시간 포맷 
		today = sdt.format(caL.getTime());  

		
		//root_id는 널값일 수 없다. 
		//root_id를 위해 Gongji1과 User 테이블을 연결해야한다
		// 일단 User들을 가져온다.
	      User author = new User("Jang");
	      User author2 = new User("Lee");
	      User author3 = new User("Ha");
	      
	      userRepository.save(author);
	      userRepository.save(author2);
	      userRepository.save(author3);
	      
	      //미리 아이템 100개를 적재
	      for(int i = 0; i < 100; i++) {
	         Gongji1 bi = new Gongji1();
	         bi.setContent(dummyString());
	         if(i % 3 == 0) {
	        	bi.setAuthor("Jang");
	            bi.setUser(author);
	            bi.setDate(today);
	            bi.setTitle("t1");
	         }
	         else if(i % 3 == 1) {
	        	bi.setAuthor("Lee");
	            bi.setUser(author2);
	            bi.setDate(today);
	            bi.setTitle("t2");
	         }
	         else {
	        	bi.setAuthor("Ha");
	            bi.setUser(author3);
	            bi.setDate(today);
	            bi.setTitle("t3");
	         }
	         gongji1Repository.save(bi);
	      }


	    // 한 페이지 아이템 10개, 0번째 페이지 호출
	    Page<Gongji1> page = gongji1Repository.findAll(PageRequest.of(0, 10));
	    printPageData("simple", page);
	    
	    // 한 페이지 아이템 10개, 글번호 내림차순으로, 0번째 페이지 호출
	    page = gongji1Repository.findAllByOrderByIdDesc(PageRequest.of(0, 10));
	    printPageData("sort_seq_desc", page);
	
	    // 한 페이지에 아이템 10개, 글번호 내림차순으로, 2번째 페이지 호출
	    page = gongji1Repository.findAll(PageRequest.of(2, 10, new Sort(Direction.DESC, "id")));
	    printPageData("sort", page);
	
	    // 한페이지에 아이템 10개, 글작성자 "Jang", 0번째 페이지 호출
	    page = gongji1Repository.findAllByAuthorContaining("Jang", PageRequest.of(0, 10));
	    printPageData("sort_author", page);
	
	    // 한페이지 아이템 10개, 작성자 내림차순으로, 2번째 페이지 호출
	    page = gongji1Repository.findAll(PageRequest.of(2, 10, new Sort(Direction.DESC, "author")));
	    printPageData("sort_author_desc", page);
	
	    // 한페이지 아이템 10개, 검색어 중, 글번호 내림차순으로, 2번째 페이지 호출
	    page = gongji1Repository.findAllSearch("bc", PageRequest.of(2, 10, new Sort(Direction.DESC, "id")));
	    printPageData("sort_search_desc", page);
	    }
	

	// 페이지 데이터 출력
	private void printPageData(String label, Page<Gongji1> page) {
		if (page == null || page.getSize() <= 0)
			return;

		for (int i = 0; i < page.getSize(); i++) {
			Gongji1 be = page.getContent().get(i);
			System.out.println("[" + label + "] " + be.getId() + " " + be.getAuthor() + " " + be.getContent());
		}
	}

	// 더미 문자열 반환
	private String dummyString() {

		String[] dummy = { "abc", "bcd", "cde", "def" };
		int rand = (int) (System.currentTimeMillis() % dummy.length);

		return dummy[rand];

	}
}
