<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
<style type="text/css">
.td {
	width: 100px;
}
</style>
</head>
<body>
	<h1>Detail</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">제목</th>
				<td>${detail.title}</td>
			</tr>
			<tr>
				<th scope="col">작성자</th>
				<td>${detail.writer}</td>
				<td class="td">${detail.regDate}</td>
			</tr>
		</thead>
		<tbody class="table-group-divider">
			<tr>
				<td>${detail.contents}</td>
				
			</tr>
			<tr>
				<td>
					<c:forEach items="${detail.qnaFileVOs}" var="detailFile">
						<div>
							<img alt="" src="/file/qna/${detailFile.fileName}">
							<a href="/fileDown/qna?fileNum=${detailFile.fileNum}">이미지 다운로드</a>
						</div>
					</c:forEach>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>