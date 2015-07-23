<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/ext.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图形展示</title>
<script type="text/javascript" language="JavaScript" src="${ctx}/resources/anychart5/js/AnyChart.js"></script>
<script type="text/javascript">
	var swfPath = ctx + '/resources/anychart5/swf/AnyChart.swf';
	var showchartA= new AnyChart(swfPath);
	$(function(){
		showchartA.width = '100%';
		showchartA.height = '95%';
		//showchartA.setXMLFile(ctx +'/static/js/app/showchart01.xml');
		showchartA.setXMLFile(ctx+'/appDispData/getShowXML');
		showchartA.write('showchartA');
	});
</script>
</head>
<body>
<div class="Tip">
<hr>
<div >
1、使用FreeMarker解决Java代码中拼凑XML(用于Anychart图展示使用)的问题
</div>
<div >
2、对Anychart的常用属性进行简单封装
</div>
<hr>
</div>
<div id="showchartA"></div>
</body>
</html>