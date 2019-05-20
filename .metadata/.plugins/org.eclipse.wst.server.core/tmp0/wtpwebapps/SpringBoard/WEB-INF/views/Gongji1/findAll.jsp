<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html lang="ko">
  <head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- meta tags 필요 -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">

<script>
function fn_paging(curPage) {
location.href = "/SpringBoard/Gongji1/findAll?page=" +curPage;
}


</script>
  </head>
<body>
FindAll.jsp
<title>게시판 목록</title>
<center><font size=5><b>게시판 목록</b></font><center>
   <table class=table align=center table style = "font-size : 14px;width:800px;">
    <colgroup>
        <col width="10%"/>
        <col width="*"/>
        <col width="20%"/>
        <col width="10%"/>
    </colgroup>
    <thead>
        <tr>
            <th scope="col">글번호</th>
            <th scope="col">제목</th>
            <th scope="col">작성일</th>
            <th scope="col">글쓴이</th>
        </tr>
    </thead>
    <tbody>
        <c:choose>
        		<c:when test="${fn:length(gongji1_list) > 0}">
                <c:forEach items="${gongji1_list}" var="gongji">
                    <tr> 
                        <td>${gongji.id}</td>
                        <td><a href='detail/${gongji.id}'>${gongji.title}</a></td>                    
                        <td>${gongji.date}</td>
                         <td>${gongji.author}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
               <tr>             
                    <td colspan="4">조회된 결과가 없습니다.</td>
                </tr>
            </c:otherwise>
        </c:choose>
        </table>
        <table align=center width=650>
 		<tr>
		<td width=170></td>
		<td width=300>

				
		</td>
		<td><button class="btn btn-primary" style="float : right;" onclick="location.href='/SpringBoard/Gongji1/insertForm'">글쓰기</button></td>
		</tr>
		</table>
		
		<form name="search" method="post">
        <table align=center width=650>
 		<tr>
		<td width=170></td>
		<td width=400>
		            <select name="keyField" size="1">
		                <option value="author" <c:if test="${'aouthor'==keyField }"> selected</c:if>> 이름 </option>
		                <option value="title" <c:if test="${'title'==keyField }"> selected</c:if>> 제목 </option>
		                <option value="content" <c:if test="${'content'==keyField }"> selected</c:if>> 내용 </option>
		            </select>
		                 <input type="text" size="16" name="searchString" value="${searchString}">
		                 <input type="button" value="검색" onClick="check()">
		                 <input type="hidden" name="page" value="0"></td>
		</tr>
		</table>
		</form> 
        </tbody>
    		<br>
		<c:choose>	
          <c:when test="${searchString eq null}">	
         <div>
             <c:if test="${pagemaker.curRange ne -1 }">
                 <a href="#" onClick="fn_paging(0)">[처음]</a> 
             </c:if>
             <c:if test="${pagemaker.curPage ne -1}">
                 <a href="#" onClick="fn_paging('${pagemaker.prevPage }')">[이전]</a> 
             </c:if>
             <c:forEach var="pageNum" begin="${pagemaker.startPage }" end="${pagemaker.endPage }">
                 <c:choose>
                     <c:when test="${pageNum eq  pagemaker.curPage}">
                         <a href="#" onClick="fn_paging('${pageNum-1 }')">${pageNum}</a></span> 
                     </c:when>
                     <c:otherwise>
                         <a href="#" onClick="fn_paging('${pageNum-1}')">${pageNum}</a> 
                     </c:otherwise>
                 </c:choose>
             </c:forEach>
             <c:if test="${pagemaker.curPage ne pagemaker.pageCnt && pagemaker.pageCnt > 0}">
                 <a href="#" onClick="fn_paging('${pagemaker.nextPage }')">[다음]</a> 
             </c:if>
             <c:if test="${pagemaker.curRange ne pagemaker.endPage}">
                 <a href="#" onClick="fn_paging('${pagemaker.pageCnt-1 }')">[끝]</a> 
             </c:if>
         </div>
          </c:when>
          <c:otherwise>
          <div>
          		<c:if test="${pagemaker.curRange ne -1 }">
          		<a href='findAll?page=0&searchString=${searchString}&keyField=${keyField}'>[처음]</a>          	
          		</c:if>
               <a href='findAll?page=${pagemaker.startPage-1}&searchString=${searchString}&keyField=${keyField}'>[이전]</a>
                <c:forEach var="i" begin="${pagemaker.startPage}" end="${pagemaker.endPage}" step="1">
                   <a href='findAll?page=${i-1}&searchString=${searchString}&keyField=${keyField}'>${i}</a>        
               </c:forEach>
               <c:if test="${pagemaker.curPage ne pagemaker.pageCnt && pagemaker.pageCnt > 0}">
               <a href='findAll?page=${pagemaker.nextPage}&searchString=${searchString}&keyField=${keyField}'>[다음]</a>	
               	</c:if>	
               <a href='findAll?page=${pagemaker.endPage-1}&searchString=${searchString}&keyField=${keyField}'>[끝]</a>
          </div>
             </c:otherwise>
           </c:choose>
          

 <script>
 
 function check() {
     if (document.search.searchString.value == "") {
         alert("검색어를 입력하세요.");
         document.search.searchString.focus();
         return;
     }
     document.search.submit();
     document.search.action = "<c:url value='/Gongji1/findAll'/>";

 }

 </script>        
</body>
</html>