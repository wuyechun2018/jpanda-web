<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%-- 注意此处路径的写法 --%>
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-1.9.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">

$(function(){
	alert('Now,we can use Jquery!');
})


</script>

<title>Welcome</title>
</head>
<body>
<h2>Hello,Jpanda!</h2>

</body>
</html>