<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/views/common/ext.jsp"%>    
<title>用户管理系统</title>
<script type="text/javascript" src="${ctx}/resources/ext-2.2.1/plugins/tipwin.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/extjs/ext_main.js"></script>
<script type="text/javascript">
/**
 * 显示系统时钟
 */
function showTime() {
	showDate();
	var date = new Date();
	var h = date.getHours();
	h = h < 10 ? '0' + h : h;
	var m = date.getMinutes();
	m = m < 10 ? '0' + m : m;
	var s = date.getSeconds();
	s = s < 10 ? '0' + s : s;
	//document.getElementById('showTime').innerHTML = h + ":" + m + ":" + s;
}

/**
 * 显示日期
 */
function showDate(){
	var date=new Date();
	var year=date.getYear();
	var month=date.getMonth()+1;
	var day=date.getDate();
	//document.getElementById('showDate').innerHTML = year + "年" + month + "月" + day+"日";
}


window.onload = function() {
	//setInterval("showTime()", 1000);
}


$(function(){
	//$('.x-tree-node a').css('color','red');
	//$('.x-tree-node a').removeAttr('onclick');
	//$('span').css('color','red');
	//alert('ok');
});

/**
 * 新增Tab页面
 */
function addNewTab(url, name, menuid, pathCh, icon) {
	var mainTabs = Ext.getCmp("mainTabs");
	var id = "tab_id_" + menuid;
	var n = mainTabs.getComponent(id);
	if (url == '#' || url == '') {
		Ext.Msg.alert('提示', '此菜单还没有指定请求地址,无法为您打开页面.');
		return;
	} else {
		if (!n) {
			n = mainTabs
					.add({
						'id' : id,
						'title' : name,
						'closable' : true,
						'tabTip' : name,
						'layout' : 'fit',
						'html' : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src='+ url + '></iframe>',
						'listeners': {
							activate: function(){
								//Ext.getCmp('centerPanel').setTitle(pathCh);
								//去除panel上标题,面包屑导航
							}}
					});
		}
		mainTabs.setActiveTab(n);
	}
}

</script>
</head>
<body>


<%--
<div id="north">
<div class="TopBox">
  <div class="TopRightBox">
    <div class="AlignBottom">
    	<a href="#" class="exit">&nbsp;</a>
    	<a href="#" class="modifyPass" onclick="closeWindow()">&nbsp;</a>
    </div>
  </div>
  <div class="TopLogo">数据监测系统</div>
</div>
</div>
 --%>
</body>
</html>