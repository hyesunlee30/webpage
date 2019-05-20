<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>게시글 보기</title>
    <!-- meta tags 필요 -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">

  </head>
<body>
 
<center><font size=5><b><br>게시글 보기<br></b></font></center>
 
<div class="container col-md-6">
    <form id="upForm" name="upForm" method="post">
        <div class="form-group">
            <label for="exampleFormControlInput1">제목</label>
            <input type="text" class="form-control" id="title" name="title" value="${detail.title }">
        </div>
        <div class="form-group">
            <label for="exampleFormControlInput1">작성자</label>
            <input type="text" class="form-control" id="author" name="author" value="${detail.author}" readonly>
        </div>
        <div class="form-group">
            <label for="exampleFormControlTextarea1">내용</label>
            <textarea class="form-control" id="content" rows="10" name="content">${detail.content }</textarea>
        </div>
        <center>
        <input type="hidden" name="id" value="${detail.id }">
        <button onClick='fn_updateGongji1()' class="btn btn-info">수정하기</button>
        <a href=<c:url value='/Gongji1/findAll'/> class="btn btn-secondary" >목록가기</a>
        </center>
    </form>
</div>

<script>
//글쓰기
function fn_updateGongji1(){
    
    var form = document.getElementById("upForm");


    if(form.title.value == ""){
        alert("제목을 입력해주세요.");
        frm.title.focus();
        return;
    }
    if(form.content.value == ""){
        alert("내용을 입력해주세요.");
        frm.content.focus();
        return;
    }       
    
  form.action= "<c:url value='/Gongji1/update/${detail.id}'/>";
  form.submit();

}

</script>
</body>
</html>


