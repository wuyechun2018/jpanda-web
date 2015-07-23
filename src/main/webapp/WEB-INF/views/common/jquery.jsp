<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<LINK href="${ctx}/resources/images/jpanda.ico" type="image/x-icon" rel="icon">                        
<LINK href="${ctx}/resources/images/jpanda.ico" type="image/x-icon" rel="shortcut icon">
<%--JQuery --%>
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript">

	var ctx = "${ctx}";

	var docWidth = 0;
	var docHeight = 0;

	if (document.documentElement.clientWidth == 0) {
		if (document.body) {
			docWidth = document.body.clientWidth;
		}
	} else {
		docWidth = document.documentElement.clientWidth;
	}

	if (document.documentElement.clientWidth == 0) {
		if (document.body) {
			docHeight = document.body.clientHeight;
		}
	} else {
		docHeight = document.documentElement.clientHeight;
	}
	//var docWidth=(document.documentElement.clientWidth == 0) ? document.body.clientWidth : document.documentElement.clientWidth;	
	//var docHeight=(document.documentElement.clientHeight == 0) ? document.body.clientHeight : document.documentElement.clientHeight;
</script>	
	