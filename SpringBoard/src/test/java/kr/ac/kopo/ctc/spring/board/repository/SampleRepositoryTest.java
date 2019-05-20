package kr.ac.kopo.ctc.spring.board.repository;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//테스트를 작성할려면 가장 먼저 어플리케이션 자체의 선언이 @SpringBootApplication 어노테이션으로 정의되야만 한다.
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleRepositoryTest {
	
	//싱글톤으로 존재하는 sampleRepository가 들어온다. 
	//하나라도 테스트가 통과를 못하면 빨간색이 뜨고 왜 틀렸는지 나온다. 
	//일반시스템을 테스트할 때 하는 것 
	@Autowired
	private SampleRepository sampleRepository;
	
	//단위테스트 시작 전 공통적으로 초기화되는 코드 
	// {@link User}나 {{@link Tx}} 엔티티를 생성하고 기본 정보를 등록한다 등의 작업 진행
	@Before
	public void before() {
		System.out.println("before");
	}
	
	//단위테스트 종료 후 공통적으로 적용될 로직
	//{@link User}나 {{@link Tx}} 엔티티를 생성하고 기본 정보를 소거하는 등의 작업 진행
	//{@link Transactional}이 걸려있다면 엔티티는 신경안써도 되겠지만
	//{@link org.springframework.test.context.jdbc.Sql} 등을 사용한 경우에는 이에 대한 초기화 용도로 사용
	@After
	public void after() {
		System.out.println("after");
	}

	//단위테스트 기본단위
	@Test
	//@Ignore - 테스트에서 제외 
	public void findAll() {
		assertEquals(5, sampleRepository.count());
	}
	
	@Test
	public void equalTest() {
		assertEquals("a","a");
	}

	@Test
	@Ignore
	public void notEqualTest() {
		assertEquals("a","b");
	}
}
