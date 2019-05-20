package kr.ac.kopo.ctc.spring.board.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.ctc.spring.board.domain.Sample;
import kr.ac.kopo.ctc.spring.board.repository.SampleRepository;
import kr.ac.kopo.ctc.spring.board.service.SampleService;

//controller를 통해 테스트
@Controller
public class SampleController {

	private static final Logger Logger = LoggerFactory.getLogger(SampleController.class);
	
	//controller, service, repository - component 상속받게 되어 있다. 해당 어플리케이션에서 딱 하나만 생기는 싱글톤!! DI, 기존 인스턴스에 삽입 
	@Autowired
	private SampleRepository sampleRepository; // Spring이 자동으로 연결한다.
	
	//요청에 대해 어떤 Controller, 어떤 메소드가 처리할지를 맵핑하기 위한 어노테이션
	//URL을 컨트롤러의 메서드와 매핑할 때 사용한다.
	@RequestMapping(value = "/sample/list")
	
	//메소드에서 리턴되는 값은 View 를 통해서 출력되지 않고 HTTP Response Body 에 직접 쓰여진다.
	//쓰여지기 전에 리턴되는 데이터 타입에 따라 MessageConverter 에서 변환이 이뤄진 후 쓰여진다
	@ResponseBody
	public List<Sample> list(Model model) {
		
		return sampleRepository.findAll();
	}

	@Autowired
	private SampleService sampleService;
	
	@RequestMapping(value = "/sample/noAop")
	@ResponseBody
	public String noAop() {
		//extends JpaRepository<Sample, Long>를 통해 findAll이 없지만 생성, CRUD 가능
		//return sampleRepository.findAllByTitleLike("%home%"); 
		//return sampleRepository.findAllByLevelGreaterThan(5);   //level을 5 이상으로 추출, 이하는 LessThan
		return sampleService.test(); 
	}
	
	@RequestMapping(value = "/sample/aop")
	@ResponseBody
	public String aop() {
		return sampleService.testAop();
	}
//	
//	@RequestMapping(value = "/sample/noTransactional")
//	@ResponseBody
//	public String noTransactional() {
//		return sampleService.testNoTransactional();
//	}
//	
//	@RequestMapping(value = "/sample/transactional")
//	@ResponseBody
//	public String transational() {
//		return sampleService.testTransactional();
//	}
}

