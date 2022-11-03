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
	<h1>Qna list</h1>
	<table class="table table-hover mb-3">
		<tr>
			<th>No</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${list}" var="list">
			<tr>
				<td>${list.num}</td>
				<td><a href="detail?num=${list.num}">${list.title}</a></td>
				<td>${list.writer}</td>
				<td>${list.hit}</td>
				<td>${list.regDate}</td>
			</tr>
		</c:forEach>
	</table>

	<a class="btn btn-primary" href="./write">글쓰기</a>
	<form action="./list" class="row g-3 mt-2">
		<select id="kind" name="kind" class="form-select" aria-label="Default select example" style="width: 100px; height: 40px;">
			<option class="kinds" value="title">제목</option>
			<option class="kinds" value="contents">내용</option>
			<option class="kinds" value="writer">작성자</option>
		</select>
			<div class="col-auto">
				<input type="text" name="search" id="search" value=""
					class="form-control" id="inputPassword2" placeholder="검색어를 입력해주세요">
			</div>
			<div class="col-auto">
				<button type="submit" class="btn btn-primary mb-3">검색</button>
			</div>
		</form>
</body>
</html>