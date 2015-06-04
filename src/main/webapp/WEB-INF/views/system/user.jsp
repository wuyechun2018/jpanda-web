<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--放置的位置要特别注意,不能放在第三行,否则会有一些样式问题 --%>
<%@ include file="/WEB-INF/views/common/comm.jsp" %>
<link href="${ctx}/resources/jqGrid/4.8.2/css/ui.jqgrid.css" rel="stylesheet" type="text/css" media="screen"  /> 
<link href="${ctx}/resources/jqGrid/4.8.2/css/ui.jqgrid-bootstarp.css" rel="stylesheet" type="text/css" media="screen"  /> 
<link href="${ctx}/resources/jquery-ui/1.11.4-redmond/jquery-ui.min.css" rel="stylesheet" type="text/css" media="screen"  /> 
<title>Jpanda</title>
<script src="${ctx}/resources/jqGrid/4.8.2/js/i18n/grid.locale-cn.js" type="text/javascript"></script>  
<script src="${ctx}/resources/jqGrid/4.8.2/js/jquery.jqGrid.min.js" type="text/javascript"></script>  
</head>
<body>
 

 
<script type="text/javascript">
var data = [
      		{id:"1",invdate:"2007-10-01",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
      		{id:"2",invdate:"2007-10-02",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
      		{id:"3",invdate:"2007-09-01",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
      		{id:"4",invdate:"2007-10-04",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
      		{id:"5",invdate:"2007-10-05",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
      		{id:"6",invdate:"2007-09-06",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
      		{id:"7",invdate:"2007-10-04",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
      		{id:"8",invdate:"2007-10-03",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
      		{id:"9",invdate:"2007-09-01",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"}
      		];


 $(function(){ 
   $("#list").jqGrid({
     //datatype: "local",
 	 //data:data,
	url: ctx+'/sysLoginUser/list',
    datatype: "json",
	colNames:['主键','用户名','密码'],
    colModel :[ 
	{name:'userId',index:'userId', width:60, sorttype:"int"},
	{name:'userName',index:'userName', width:90, sorttype:"date"},
	{name:'loginPwd',index:'loginPwd', width:150, sortable:false}	 
     ],
     pager: "#pager",
     rowNum:10, 
     rowList:[10,20,30],
     rownumbers:true, 
     sortname: "id",   
     sortorder: "desc", 
     viewrecords: true, 
     gridview: true,
     caption: "用户列表",
     width:docWidth-400, 
     height:docHeight-200
   }); 
 }); 
</script>

 <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="#">管理界面</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav pull-right">
                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"> <i class="icon-user"></i> Admin <i class="caret"></i>

                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a tabindex="-1" href="#">我的账户</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a tabindex="-1" href="${ctx}/logout">退出</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="nav">
                            <li class="active">
                                <a href="#">主页面</a>
                            </li>
                            <li class="dropdown">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle">配置 <b class="caret"></b>

                                </a>
                                <ul class="dropdown-menu" id="menu1">
                                    <li>
                                        <a href="#">Tools <i class="icon-arrow-right"></i>

                                        </a>
                                        <ul class="dropdown-menu sub-menu">
                                            <li>
                                                <a href="#">Reports</a>
                                            </li>
                                            <li>
                                                <a href="#">Logs</a>
                                            </li>
                                            <li>
                                                <a href="#">Errors</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="#">SEO Settings</a>
                                    </li>
                                    <li>
                                        <a href="#">Other Link</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a href="#">Other Link</a>
                                    </li>
                                    <li>
                                        <a href="#">Other Link</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">内容页 <i class="caret"></i>

                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a tabindex="-1" href="#">Blog</a>
                                    </li>
                                    <li>
                                        <a tabindex="-1" href="#">News</a>
                                    </li>
                                    <li>
                                        <a tabindex="-1" href="#">Custom Pages</a>
                                    </li>
                                    <li>
                                        <a tabindex="-1" href="#">Calendar</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a tabindex="-1" href="#">FAQ</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">用户 <i class="caret"></i>

                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a tabindex="-1" href="#">User List</a>
                                    </li>
                                    <li>
                                        <a tabindex="-1" href="#">Search</a>
                                    </li>
                                    <li>
                                        <a tabindex="-1" href="#">Permissions</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <!--/.nav-collapse -->
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span3" id="sidebar">
                    <ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
                        <li >
                            <a href="${ctx}/views/system/main"><i class="icon-chevron-right"></i>主页面</a>
                        </li>
                        <li class="active">
                            <a href="${ctx}/views/system/user"><i class="icon-chevron-right"></i>用户</a>
                        </li>
                        <li>
                            <a href="${ctx}/views/system/user"><i class="icon-chevron-right"></i>角色</a>
                        </li>
                        <li>
                            <a href="${ctx}/views/system/user"><i class="icon-chevron-right"></i> 权限</a>
                        </li>
                        <li>
                            <a href="${ctx}/views/system/report"><i class="icon-chevron-right"></i> 图表</a>
                        </li>
                         <li >
                            <a href="${ctx}/views/system/report"><span class="badge badge-info pull-right">11</span> 报表</a>
                        </li>
                         <li>
                            <a href="${ctx}/views/system/log"><span class="badge badge-warning pull-right">4,231</span> 日志</a>
                        </li>
                    </ul>
                </div>
                
                <!--/span-->
                <div class="span9" id="content">
               		<table id="list"></table>   
					<div id="pager"></div>
                </div>
                </div>
            </div>
            <hr>
            <footer>
                <p>&copy; Vincent Gabriel 2013</p>
            </footer>
        
        <script src="${ctx}/resources/assets/DT_bootstrap.js"></script>
 
</body>
</html>