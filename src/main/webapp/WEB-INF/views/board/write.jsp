<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<h1>Write</h1>
	
	<form action="./writer" method="POST">
	
	<!-- 작성자 -->
	<div class="row g-3 align-items-center">
		<div class="col-auto">
			<label for="inputPassword6" class="col-form-label">Writer</label>
		</div>
		<div class="col-auto">
			<input type="text" name="writer" id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline">
		</div>
	</div>
	
	<!-- 제목 -->
	<div class="row g-3 align-items-center">
		<div class="col-auto">
			<label for="inputPassword6" class="col-form-label">Title</label>
		</div>
		<div class="col-auto">
			<input type="text" name="title" id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline">
		</div>
	</div>
	
	<!-- 내용 -->
	<div class="row g-3 align-items-center">
		<div class="col-auto">
			<label for="inputPassword6" class="col-form-label">Contents</label>
		</div>
		<div class="col-auto">
			<textarea class="form-control" name="contents" id="exampleFormControlTextarea1" rows="3"></textarea>
		</div>
	</div>
	
	<button type="submit" class="btn btn-primary">작성</button>
	
	</form>
	
</body>
</html>