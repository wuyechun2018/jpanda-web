<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--放置的位置要特别注意,不能放在第三行,否则会有一些样式问题 --%>
<%@ include file="/WEB-INF/views/common/comm.jsp" %>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/bootstrap-wysihtml5/src/bootstrap-wysihtml5.css"></link>
<link href="${ctx}/resources/assets/DT_bootstrap.css" rel="stylesheet" media="screen">
<title>Jpanda</title>
</head>
<body>
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
                <div class="span2" id="sidebar">
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
                
                <div class="span10">
                	<div class="row-fluid">


		                <div class="span12" id="content">
		                    <div class="row-fluid">
		                        <!-- block -->
		                        <div class="block">
		                            <div class="navbar navbar-inner block-header">
		                                <div class="muted pull-left">CKEditor Standard</div>
		                            </div>
		                            <div class="block-content collapse in">
		                               <textarea id="ckeditor_standard"></textarea>
		                            </div>
		                        </div>
		                        <!-- /block -->
		                    </div>
		                </div>

		                <div class="span12" id="content">
		                    <div class="row-fluid">
		                        <!-- block -->
		                        <div class="block">
		                            <div class="navbar navbar-inner block-header">
		                                <div class="muted pull-left">CKEditor Full</div>
		                            </div>
		                            <div class="block-content collapse in">
		                               <textarea id="ckeditor_full"></textarea>
		                            </div>
		                        </div>
		                        <!-- /block -->
		                    </div>
		                </div>

		                <div class="span12" id="content">
		                    <div class="row-fluid">
		                        <!-- block -->
		                        <div class="block">
		                            <div class="navbar navbar-inner block-header">
		                                <div class="muted pull-left">TinyMCE Basic</div>
		                            </div>
		                            <div class="block-content collapse in">
		                               <textarea id="tinymce_basic"></textarea>
		                            </div>
		                        </div>
		                        <!-- /block -->
		                    </div>
		                </div>

		                <div class="span12" id="content">
		                    <div class="row-fluid">
		                        <!-- block -->
		                        <div class="block">
		                            <div class="navbar navbar-inner block-header">
		                                <div class="muted pull-left">TinyMCE Full</div>
		                            </div>
		                            <div class="block-content collapse in">
		                               <textarea id="tinymce_full"></textarea>
		                            </div>
		                        </div>
		                        <!-- /block -->
		                    </div>
		                </div>

		                <div class="span12" id="content">
		                    <div class="row-fluid">
		                        <!-- block -->
		                        <div class="block">
		                            <div class="navbar navbar-inner block-header">
		                                <div class="muted pull-left">Bootstrap WYSIWYG</div>
		                            </div>
		                            <div class="block-content collapse in">
		                               <textarea id="bootstrap-editor" placeholder="Enter text ..." style="width:98%;height:200px;"></textarea>
		                            </div>
		                        </div>
		                        <!-- /block -->
		                    </div>
		                </div>

                	</div>
                </div>

            </div>
            <hr>
            <footer>
                <p>&copy; Vincent Gabriel 2013</p>
            </footer>
        </div>
        
        <script src="${ctx}/resources/ckeditor/adapters/jquery.js"></script>
       <script type="text/javascript" src="${ctx}/resources/bootstrap-wysihtml5/lib/js/wysihtml5-0.3.0.js"></script>
        <script  type="text/javascript" src="${ctx}/resources/ckeditor/ckeditor.js"></script>
        <script src="${ctx}/resources/ckeditor/adapters/jquery.js"></script>
       <script type="text/javascript" src="${ctx}/resources/bootstrap-wysihtml5/src/bootstrap-wysihtml5.js"></script>
       
       <script type="text/javascript" src="${ctx}/resources/tinymce/tinymce.min.js"></script> 
      <script type="text/javascript">
        $(function() {
            // Bootstrap
            $('#bootstrap-editor').wysihtml5();

            // Ckeditor standard
            $( '#ckeditor_standard').ckeditor({width:'98%', height: '150px', toolbar: [
				{ name: 'document', items: [ 'Source', '-', 'NewPage', 'Preview', '-', 'Templates' ] },	// Defines toolbar group with name (used to create voice label) and items in 3 subgroups.
				[ 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo' ],			// Defines toolbar group without name.
				{ name: 'basicstyles', items: [ 'Bold', 'Italic' ] }
			]});
            $('#ckeditor_full').ckeditor({width:'98%', height: '150px'});
        });

        // Tiny MCE
        tinymce.init({
		    selector: "#tinymce_basic",
		    plugins: [
		        "advlist autolink lists link image charmap print preview anchor",
		        "searchreplace visualblocks code fullscreen",
		        "insertdatetime media table contextmenu paste"
		    ],
		    toolbar: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image"
		});

		// Tiny MCE
        tinymce.init({
		    selector: "#tinymce_full",
		    plugins: [
		        "advlist autolink lists link image charmap print preview hr anchor pagebreak",
		        "searchreplace wordcount visualblocks visualchars code fullscreen",
		        "insertdatetime media nonbreaking save table contextmenu directionality",
		        "emoticons template paste textcolor"
		    ],
		    toolbar1: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image",
		    toolbar2: "print preview media | forecolor backcolor emoticons",
		    image_advtab: true,
		    templates: [
		        {title: 'Test template 1', content: 'Test 1'},
		        {title: 'Test template 2', content: 'Test 2'}
		    ]
		});
		


        </script>
</body>
</html>