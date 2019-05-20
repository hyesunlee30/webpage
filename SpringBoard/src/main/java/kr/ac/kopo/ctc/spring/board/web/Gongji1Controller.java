package kr.ac.kopo.ctc.spring.board.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.ctc.spring.board.domain.Gongji1;
import kr.ac.kopo.ctc.spring.board.domain.User;
import kr.ac.kopo.ctc.spring.board.dto.Gongji1Dto;
import kr.ac.kopo.ctc.spring.board.repository.Gongji1Repository;
import kr.ac.kopo.ctc.spring.board.repository.UserRepository;
//service import
import kr.ac.kopo.ctc.spring.board.service.Gongji1Service;




@Controller
public class Gongji1Controller {
   
   Logger log = Logger.getLogger(this.getClass());
   
   @Autowired
   private Gongji1Repository gongji1repository;

   @Autowired
   private UserRepository userRepo;

      

   //Controller는 단순히 어떤 주소와 화면을 연결하고 비지니스 로직을 호출하는 역할을 한다.
   //실제로 여러가지 비지니스 로직은 Service에서 작성한다. 
   //나중에 게시글 상세조회의 경우 조회수 증가와 게시글 상세내용을 조회하는 두가지 기능이 필요한데
   //이를 service에서 처리해주게 된다. 
   @Resource(name="gongji1Service")
   private Gongji1Service gongji1Service;
   
   //Url 요청
   @RequestMapping(value = "/Gongji1/findAll") //http://192.168.23.26:8082/SpringBoard/Gongji1/findAll
   public String findAll(Model model,Pageable pageable, String searchString, String keyField) throws Exception {
        // 모델 설정(model에 도메인 객체 전달) 
          //Map은 key-value, key-value... 형태임
      //일단 왼쪽은 단순한 변수의 선언
      //오른쪽은 게시판 목록을 보여주기 때문에 목록을 저장할 수 있는 List를 선언.
      //gongji1_list에 글번호 글제목 작성일 등의 키와 실제 값이 저장된다. 
      
      
      
      if (searchString == null) searchString = "";
      if (keyField == null) keyField = "";

      if(searchString != "") {
      
    	  System.out.println("00000");
      if (keyField.equals("author") ) {
    	  System.out.println("11111111");
         
         Page<Gongji1> page = gongji1repository.findAllByAuthorContaining(searchString, pageable);
         
         int listCnt = (int)page.getTotalElements();
         
         int curPage = 0;
         curPage = page.getNumber();
         Gongji1Dto pagemaker = new Gongji1Dto(listCnt, curPage);
         Page<Gongji1> page2 = gongji1repository.findAllByAuthorContaining(searchString,PageRequest.of(curPage, 10));
         //현재페이지와 조회할 페이지 
         
         
         List<Gongji1>gongji1_list = page2.getContent();
         
         
         
         //findAll한 값을 리시트에 담음
      //   List<Gongji1>gongji1_list = page.getContent();
            //서비스로직의 결과를 gomgji1_list 객체에 담아서 
            //jsp에서 결과를 사용할 수 있도록 한다. 

          model.addAttribute("gongji1_list",gongji1_list);
          
          model.addAttribute("listCnt", listCnt);

          model.addAttribute("pagemaker", pagemaker);
          
          model.addAttribute("keyField", keyField);
          
          model.addAttribute("searchString", searchString);
          
         
      }
      if (keyField.equals("title")) {
    	  System.out.println("222222222");
         Page<Gongji1> page = gongji1repository.findAllByTitleContaining(searchString, pageable);
         
         int listCnt = (int)page.getTotalElements();
         
         int curPage = 0;
         curPage = page.getNumber();
         Gongji1Dto pagemaker = new Gongji1Dto(listCnt, curPage);
         Page<Gongji1> page2 = gongji1repository.findAllByTitleContaining(searchString,PageRequest.of(curPage, 10));
         
         //현재페이지와 조회할 페이지 
         
         
         List<Gongji1>gongji1_list = page2.getContent();
         
         
         
         //findAll한 값을 리시트에 담음
      //   List<Gongji1>gongji1_list = page.getContent();
            //서비스로직의 결과를 gomgji1_list 객체에 담아서 
            //jsp에서 결과를 사용할 수 있도록 한다. 

          model.addAttribute("gongji1_list",gongji1_list);
          
          model.addAttribute("listCnt", listCnt);

          model.addAttribute("pagemaker", pagemaker);
          
          model.addAttribute("keyField", keyField);
          
          model.addAttribute("searchString", searchString);
          

         
      }
      
      if (keyField.equals("content")) {
    	  
    	  System.out.println("33333333");
    	  
         Page<Gongji1> page = gongji1repository.findAllSearch(searchString, pageable);
         
         int listCnt = (int)page.getTotalElements();
         
         int curPage = 0;
         curPage = page.getNumber();
         Gongji1Dto pagemaker = new Gongji1Dto(listCnt, curPage);
         Page<Gongji1> page2 = gongji1repository.findAllSearch(searchString,PageRequest.of(curPage, 10));
         
         //현재페이지와 조회할 페이지 
         
         
         List<Gongji1>gongji1_list = page2.getContent();
         
         
         
         //findAll한 값을 리시트에 담음
      //   List<Gongji1>gongji1_list = page.getContent();
            //서비스로직의 결과를 gomgji1_list 객체에 담아서 
            //jsp에서 결과를 사용할 수 있도록 한다. 

          model.addAttribute("gongji1_list",gongji1_list);
          
          model.addAttribute("listCnt", listCnt);

          model.addAttribute("pagemaker", pagemaker);
          
          model.addAttribute("keyField", keyField);
         
          model.addAttribute("searchString", searchString);
      } 
      
      }
      else {
    	  
    	  System.out.println("444444");
         Page<Gongji1> page = gongji1repository.findAll(pageable);
         
         int listCnt = (int)page.getTotalElements();
         
         int curPage = 0;
         curPage = page.getNumber();
         
         Gongji1Dto pagemaker = new Gongji1Dto(listCnt, curPage);
         Page<Gongji1> page2 = gongji1repository.findAll(PageRequest.of(curPage, 10));
         
         //현재페이지와 조회할 페이지 
         
         
         List<Gongji1>gongji1_list = page2.getContent();
         
         
         
         //findAll한 값을 리시트에 담음
      //   List<Gongji1>gongji1_list = page.getContent();
            //서비스로직의 결과를 gomgji1_list 객체에 담아서 
            //jsp에서 결과를 사용할 수 있도록 한다. 

          model.addAttribute("gongji1_list",gongji1_list);
          
          model.addAttribute("listCnt", listCnt);

          model.addAttribute("pagemaker", pagemaker);
                 

         
      }
      

      return "Gongji1/findAll";

   }

   
   @RequestMapping(value = "/api/Gongji1/findAll") //http://192.168.23.26:8082/SpringBoard/api/Gongji1/findAll
   public String apiFindAll(Model model, @RequestParam HashMap<String, String> map) throws Exception {
      model.addAttribute("name", "홍길동1"); //("key", "velue")
      return "api/Gongji1/findAll";
   }
   
   
     @RequestMapping(value="/Gongji1/detail/{id}") 
       private String Gongji1_Detail(@PathVariable int id, Model model) throws Exception{
           
        Gongji1 gongji = gongji1repository.findById(id).get();   //@Autowired를 사용해 위에서 gongji1repository를 받아옴

        model.addAttribute("gongji",gongji);
       
           
           return "Gongji1/detail";
       }
    
       @RequestMapping(value="/Gongji1/insertForm") //게시글 작성폼 호출  
       public String insertForm() throws Exception{
           
           return "Gongji1/insertForm";
       }     

     
      @RequestMapping(value="/Gongji1/insert" , method = RequestMethod.POST) 
       private String Gongji1_insert(Model model, @RequestParam HashMap<String, String> map) {
           

         Gongji1 gongji = new Gongji1();
         
         String today ="";
         
         Calendar caL = Calendar.getInstance(); // 날짜 가져오기 
         SimpleDateFormat sdt = new SimpleDateFormat("YYYY-MM-dd"); // 날짜 시간 포맷 
         today = sdt.format(caL.getTime()); 
         

            User author2 = new User(map.get("author"));
            userRepo.save(author2);

          gongji.setAuthor(map.get("author"));
          gongji.setTitle(map.get("title"));
             gongji.setDate(today);
             gongji.setContent(map.get("content"));         
             gongji.setUser(author2);

         gongji1repository.save(gongji);

           return "redirect:/Gongji1/findAll";
       }

       @RequestMapping(value="/Gongji1/updateForm/{id}") //게시글 수정폼 호출  
       private String updateForm(@PathVariable int id, Model model) throws Exception{
           

          Gongji1 detail = gongji1repository.findById(id).get();   //@Autowired를 사용해 위에서 gongji1repository를 받아옴
          
          model.addAttribute("detail",detail);

           return "Gongji1/updateForm";
       }
      

       @RequestMapping(value ="/Gongji1/update/{id}", method=RequestMethod.POST) //게시글 수정폼 호출  
       private String boardUpdateForm(Model model,@PathVariable int id, @RequestParam HashMap<String, String> map) throws Exception{
           

         Gongji1 update = gongji1repository.findById(id).get(); 


               update.setTitle(map.get("title"));
                update.setContent(map.get("content"));
                

                gongji1repository.save(update);
           return "redirect:/Gongji1/findAll";
       }

       @RequestMapping(value ="/Gongji1/delete/{id}")
       private String boardDelete(@PathVariable int id) throws Exception{
          
          Gongji1 gongji = gongji1repository.findById(id).get();   //@Autowired를 사용해 위에서 gongji1repository를 받아옴
   

         gongji1repository.delete(gongji);
           
           return "redirect:/Gongji1/findAll";
       }


}