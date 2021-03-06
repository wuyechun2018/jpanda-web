<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-1.9.1.min.js"></script>


<link href="${ctx}/resources/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="${ctx}/resources/bootstrap/2.3.2/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
<link href="${ctx}/resources/easypiechart/jquery.easy-pie-chart.css" rel="stylesheet" media="screen">
<link href="${ctx}/resources/assets/styles.css" rel="stylesheet" media="screen">


<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
<script src="${ctx}/resources/jquery/html5.js"></script>
<![endif]-->
<script src="${ctx}/resources/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<title></title>
</head>
<body>
<script src="${ctx}/resources/bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="${ctx}/resources/easypiechart/jquery.easy-pie-chart.js"></script>
<script src="${ctx}/resources/datatables/js/jquery.dataTables.min.js"></script>
<script src="${ctx}/resources/assets/scripts.js"></script>

<script type="text/javascript">

var ctx = "${ctx}";

var docWidth=0;
var docHeight=0;

if(document.documentElement.clientWidth == 0){
	if(document.body){
		docWidth=document.body.clientWidth;
	}
}else{
	docWidth=document.documentElement.clientWidth;
}

if(document.documentElement.clientWidth == 0){
	if(document.body){
		docHeight=document.body.clientHeight;
	}
}else{
	docHeight= document.documentElement.clientHeight;
}





</script>




</body>
</html>