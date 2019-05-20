package kr.ac.kopo.ctc.spring.board.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//AsprectJ 규칙 추가
@Aspect
@Component
public class LogAspect {
   private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

   
   //execution(* kr.ac.kopo.ctc.spring.board.service. 여기까지가 주소
   //*.*Aop(..)) 뒤에까지 다 쓰면 저 주소의 모든 클래스를 뽑아온다는 말
   //조인포인트 앞에서 실행할 어드바이스
   @Before("execution(* kr.ac.kopo.ctc.spring.board.service.*.*Aop(..))")
   public void onBeforeHandler(JoinPoint joinPoint) {
         logger.info("==================== onBeforeThing");
   }
   //조인포인트 뒤에서 실행할 어드바이스   
   @After("execution(* kr.ac.kopo.ctc.spring.board.service.*.*Aop(..))")
   public void onAfterHandler(JoinPoint joinPoint) {
      logger.info("==================== onAfterHandler");
   }
   //조인포인트 완전히 정상 종료한 다음 실행되는 어드바이스
   @AfterReturning(pointcut = "execution(* kr.ac.kopo.ctc.spring.board.service.*.*Aop(..))", returning = "str")
   public void onAfterReturningHandler(JoinPoint joinPoint, Object str) {
      logger.info("@AfterReturning : " + str);
      logger.info("==================== onAfterReturningHandler");
   }
   
//   //조인포인트 앞뒤에서 실행되는 어드바이스
//   @Around("execution(* kr.ac.kopo.ctc.spring.board.service.*.*Aop(..))")
//   public Object onAround(ProceedingJoinPoint proceedingJoinPoint) {
//      logger.info("@Around Start");
//      Object result = null;
//      try {
//         result = proceedingJoinPoint.proceed();
//      } catch (Throwable e) {
//         e.printStackTrace();
//      }
//      logger.info("@Around End");
//      return result;
//   }
//   //조인포인트 완전히 정상 종료한 다음 실행되는 어드바이스   
//   @AfterReturning(pointcut = "onPointcut()")
//   public void onAfterReturningByPointcut() {
//      logger.info("==================== onAfterReturningByPointcut");
//   }
   //조인포인트와 어드바이스의 중간에 있으면서 처리가 조인 포인트에 이르렀을 때 어드바이스를 호출할지 선별
   @Pointcut("execution(* kr.ac.kopo.ctc.spring.board.service.*.*Aop(..))")
   public void onPointcut(JoinPoint joinPoint) {
      logger.info("==================== onPointcut");
   }
}
