package kr.ac.kopo.ctc.spring.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {

	//1. 모델셋팅
	//2. 뷰지정
	//3. return 한 값에 serfix prefix 붙여서 jsp에 접속 
	@RequestMapping(value = "/hello") //192.168.23.26:8082/hello 
	public String hellSpringBoot(Model model) {
		model.addAttribute("name", "홍길동"); //("key", "velue")
		model.addAttribute("age","30");
		model.addAttribute("tel","010-0100");
		model.addAttribute("email", "aaa@aa");
		
		//Sample s = new Sample();
		// source, generate getter and setter
		//s.setId(5L);
		//s.setTitle("title1234");
		
		//model.addAttribute("sample",s);
		
		return "hello"; // 출력
	}
}
