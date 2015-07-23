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
	var showchartB = new AnyChart(swfPath);
	var showchartC= new AnyChart(swfPath);
	var showchartD= new AnyChart(swfPath);
	var showchartE= new AnyChart(swfPath);
	var showchartF= new AnyChart(swfPath);
	$(function(){
		
		showchartA.width = '100%';
		showchartA.height = '50%';
		showchartA.setXMLFile(ctx +'/resources/js/app/showchart01.xml');
		showchartA.write('showchartA');

		showchartB.width = '100%';
		showchartB.height = '50%';
		showchartB.setXMLFile(ctx +'/resources/js/app/showchart02.xml');
		showchartB.write('showchartB');


		showchartC.width = '100%';
		showchartC.height = '50%';
		showchartC.setXMLFile(ctx +'/resources/js/app/showchart03.xml');
		showchartC.write('showchartC');

		showchartD.width = '100%';
		showchartD.height = '50%';
		showchartD.setXMLFile(ctx +'/resources/js/app/showchart04.xml');
		showchartD.write('showchartD');

		showchartE.width = '100%';
		showchartE.height = '50%';
		showchartE.setXMLFile(ctx +'/resources/js/app/showchart05.xml');
		showchartE.write('showchartE');

		showchartF.width = '100%';
		showchartF.height = '50%';
		showchartF.setXMLFile(ctx +'/resources/js/app/showchart06.xml');
		showchartF.write('showchartF');
	});
</script>
</head>
<body>
<div id="showchartA"></div>
<div id="showchartB"></div>
<div id="showchartC"></div>
<div id="showchartD"></div>
<div id="showchartE"></div>
<div id="showchartF"></div>
</body>
</html>