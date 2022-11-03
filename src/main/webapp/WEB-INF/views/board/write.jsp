<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
<c:import url="../temp/summer.jsp"></c:import>
<script defer src="/js/board/writeAddFile.js"></script>
</head>
<body>
	<h1>Write</h1>

	<form:form action="./write" method="POST" modelAttribute="qnaVO" enctype="multipart/form-data">
		<!-- 작성자 -->
		<div class="form-floating mb-3">
			<!-- <input type="text" name="writer" class="form-control" id="floatingInput" placeholder="작성자"> -->
			<form:input path="writer" cssClass="form-control" /> 
			<label for="floatingInput">Writer</label>
		</div>
		<form:errors path="writer"></form:errors>
		
		<!-- 제목 -->
		<div class="form-floating mb-3">
			<input type="text" name="title" class="form-control" id="floatingPassword" placeholder="제목"> 
			<label for="floatingPassword">Title</label>
		</div>
		<form:errors path="title"></form:errors>
		
		<!-- 내용 -->
		<div class="form-floating mb-3">
		  <textarea name="contents" class="form-control" placeholder="내용" id="contents"></textarea>
		</div>
		<form:errors path="contents"></form:errors>
		
		<!-- 첨부파일 -->
		<div class="mb-3">
			<div>
				<button type="button" id="fileAddBtn" class="btn btn-secondary">파일 추가</button>
			</div>
			<div id="fileAddForm"></div>
			<div id="fileAddCheck"></div>
		</div>

		<button type="submit" class="btn btn-primary">작성</button>
		<a href="./list" type="button" class="btn btn-danger">취소</a>

	</form:form>
	<script>
      $(document).ready(function () {
           $('#contents').summernote({
        	   height: 250
         });
      });
   </script>
</body>
</html>