package kr.ac.kopo.ctc.spring.board.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.spring.board.domain.Sample;
import kr.ac.kopo.ctc.spring.board.repository.SampleRepository;

//AsprectJ이 적용될 서비스 추가
@Service
public class SampleServiceImpl implements SampleService {
   
   private static final Logger logger = LoggerFactory.getLogger(SampleServiceImpl.class);
   
   @Autowired   //sampleRepositoy들고오는 방법:자동연결 spring이 알아서 해줌(single톤으로 존재하는걸 들고옴)
   private SampleRepository sampleRepository;
   
   //실질적으로 들어가는 내용부분
   @Override
   public String test() {
      String msg = "Hello, Spring Boot No AOP";
      logger.info(msg);
      return msg;
   }
   
   @Override
   public String testAop() {
      String msg = "Hello, Spring Boot AOP";
      logger.info(msg);
      return msg;
   }
   
   @Override
   public String testNoTransactional() {
      Sample sample = sampleRepository.findById(1L).get();
      sample.setTitle("update1");
      sampleRepository.save(sample);
      
      throw new RuntimeException("Spring Boot No Transactional Test");
   }
   
   
   
   @Override
   @Transactional
   public String testTransactional() {
      Sample sample = sampleRepository.findById(1L).get();
      sample.setTitle("update1");
      sampleRepository.save(sample);
      
      throw new RuntimeException("Spring Boot Transactional Test");
   }
   
}

