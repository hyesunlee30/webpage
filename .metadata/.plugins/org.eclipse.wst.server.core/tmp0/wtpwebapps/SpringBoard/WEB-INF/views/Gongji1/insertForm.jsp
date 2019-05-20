<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 작성</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>게시글 작성</title>
    <!-- meta tags 필요 -->


    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">

  </head>
   
<body>
<center><font size=5><b><br>게시글 작성<br></b></font></center>
<div class="container col-md-6">
    <form method="POST" id="insertForm" name="insertForm">
          <div class="form-group">
            <label for="exampleFormControlInput1">제목</label>
            <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요." >
        </div>
        <div class="form-group">
            <label for="exampleFormControlInput1">작성자</label>
            <input type="text" class="form-control" id="author" name="author" placeholder="이름을 입력하세요."   >
        </div>
        <div class="form-group">
            <label for="exampleFormControlTextarea1">내용</label>
            <textarea class="form-control" id="content" rows="10" name="content" style="width:100%;resize:none;" placeholder="내용을 입력하세요." ></textarea>
        </div>	
        <center>        	
			 <button onClick='fn_addtoGongji1()' class="btn btn-info" >글 등록</button>
             <button onClick='fn_cancel()' class="btn btn-secondary">목록</button>
        </center>             
    </form>   
<script>
//글쓰기
function fn_addtoGongji1(){
    
    var form = document.getElementById("insertForm");


    if(form.title.value == ""){
        alert("제목을 입력해주세요.");
        frm.title.focus();
        return;
    }
    if(form.author.value == ""){
        alert("작성자를 입력해주세요.");
        frm.author.focus();
        return;
    } 
    if(form.content.value == ""){
        alert("내용을 입력해주세요.");
        frm.content.focus();
        return;
    }       
    
  form.action = "<c:url value='/Gongji1/insert'/>";
  form.submit();

}
 
//목록
function fn_cancel(){
    
    var form = document.getElementById("insertForm");

    form.action = "<c:url value='/Gongji1/findAll'/>";
    form.submit();
    
}
</script>
</div>
</body>
</html>
