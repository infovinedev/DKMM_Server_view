<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<c:set var="proSdate" value="20210510"/>
<c:set var="proEdate" value="20210510"/>
<c:if test="${not empty start_date}">
	<c:set var="proSdate" value="${start_date}" />
	<c:set var="proEdate" value="${close_date}" />
</c:if>

<c:set var="isPro" value="true"/><%-- true로 설정. 기존과 동일. false로 할 경우 프로모션이 없을 경우, 휴대폰번호 인증할 수 없음. --%>
<c:if test="${today >= proSdate && today <= proEdate}">
	<c:set var="isPro" value="true"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Pretendard&amp;display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans+KR&amp;display=swap" rel="stylesheet">
<script async src="https://www.googletagmanager.com/gtag/js?id=G-TH0S518PP1"></script>
<script>
	window.dataLayer = window.dataLayer || [];
	function gtag(){dataLayer.push(arguments);}
	gtag('js', new Date());

	gtag('config', 'G-TH0S518PP1');
</script>
<style>
	html, body {
		width: 100%; height: 100%;
	}
</style>
</head>
<body style="margin: 0px!important;">
	<div style="width:100%">
		<div style="display: inline-block; width:30%;">

		</div>
		<div style="display: inline-block; width:40%;">
			<c:choose>
				<c:when test="${today>=proSdate and not empty promotion_image}">
				<%--여기가 새롭게 적용될 이미지 주소 --%>
				<img src="${promotion_image}" alt="${promotion_image_alt}" style="width:100%;" />
				</c:when>
				<c:otherwise>
			<img src="/assets/images/promotion/theend.jpg" style="width:100%;" />
				</c:otherwise>
			</c:choose>

		</div>
		<div style="display: inline-block; width:30%;">

		</div>
	</div>
</body>
</html>