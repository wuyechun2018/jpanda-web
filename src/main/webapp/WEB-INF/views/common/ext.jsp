<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<LINK href="${ctx}/resources/images/favicon.ico" type="image/x-icon" rel="icon">                        
<LINK href="${ctx}/resources/images/favicon.ico" type="image/x-icon" rel="shortcut icon">
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-1.9.1.min.js"></script>
<link type="text/css" href="${ctx}/resources/styles/base.css" rel="stylesheet" />
<link type="text/css" href="${ctx}/resources/ext-2.2.1/resources/css/ext-all.css" rel="stylesheet" />
<link type="text/css" href="${ctx}/resources/ext-2.2.1/resources/css/aicons.css" rel="stylesheet" />
<link type="text/css" href="${ctx}/resources/ext-2.2.1/resources/css/aiext.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/resources/ext-2.2.1/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="${ctx}/resources/ext-2.2.1/ext-all.js"></script>
<%--
<script type="text/javascript" src="${ctx}/resources/ext-2.2.1/ext-all-debug.js"></script>
 --%>
<script type="text/javascript" src="${ctx}/resources/ext-2.2.1/source/locale/ext-lang-zh_CN.js"></script>
<script type="text/javascript" src="${ctx}/resources/ext-2.2.1/plugins/TabCloseMenu.js"></script>
<script type="text/javascript" src="${ctx}/resources/ext-2.2.1/plugins/Fw.ux.Button.js"></script>
<script type="text/javascript" src="${ctx}/resources/ext-2.2.1/plugins/Form_Override.js"></script>
<script type="text/javascript" src="${ctx}/resources/ext-2.2.1/plugins/Ext.ux.grid.Columnformat.js"></script>
<script type="text/javascript" src="${ctx}/resources/ext-2.2.1/plugins/Ext_Session_Timeout.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/common/dateformat_extend.js"></script>
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
	//var docWidth=(document.documentElement.clientWidth == 0) ? document.body.clientWidth : document.documentElement.clientWidth;	
	//var docHeight=(document.documentElement.clientHeight == 0) ? document.body.clientHeight : document.documentElement.clientHeight;
	
	//遮挡ActiveX
	Ext.useShims = true;
	Ext.QuickTips.init();

	//处理readonly的backspace页面后退问题
	Ext.EventManager.on(Ext.isIE ? document : window, 'keydown', function(e, t) {
		if (e.getKey() == e.BACKSPACE && (t.disabled || t.readOnly)) {
			e.stopEvent();
		}
	}); 
</script>	
	