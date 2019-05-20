package kr.ac.kopo.ctc.spring.board;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
//->SpringBootApplication 어노테이션의 속성 중 하나
//->exclude는 EnableAutoConfiguration의 속성 중 하나 
//이것이 실제로 Spring boot의 핵심적인 어노테이션이며 자동 설정을 담담한다.
//exclude는 클래스 형태로 만약 자동 설정을 하고 싶지 않는 클래스가 있다명 해당 속성을 이용해
//자동설정에서 제외 시킬 수 있다.
public class SpringBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoardApplication.class, args);
	}

}

