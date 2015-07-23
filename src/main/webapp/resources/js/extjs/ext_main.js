//退出系统
function doExit(){
	Ext.MessageBox.confirm("确认", "确定要退出本系统？",
									function(btn) {
										if (btn == "yes") {
											location.href=ctx+"/loginout";
											 //不提示，直接关闭
											 window.opener=null;
      										 window.open('', '_self', '');
											 window.close();
										}
									});
}


//重新登录
function relogin(){
	 window.location=ctx+'/loginout';
}

//修改密码表单
var changePwdForm = new Ext.FormPanel({
	frame : true,
	labelAlign : 'left',
	autoWidth : true,
	bodyStyle : 'padding:10px',
	items : [{
		xtype : 'fieldset',
		labelAlign : 'right',
		buttonAlign : 'center',
		labelWidth : 60,
		title : '修改密码',
		defaults : {
			width : 300
		},
		defaultType : 'textfield',
		autoHeight : true,
		items : [{
					fieldLabel : '当前密码',
					inputType : 'password',
					name : 'lastPwd',
					unitText : '<font color=red>*</font>',
					allowBlank : false
				}, {
					fieldLabel : '新密码',
					inputType : 'password',
					name : 'newPwd',
					unitText : '<font color=red>*</font>',
					allowBlank : false,
					maxLength:10,
					minLength:3
				}, {
					fieldLabel : '确认密码',
					inputType : 'password',
					name : 'newPwdConfirm',
					unitText : '<font color=red>*</font>',
					allowBlank : false
				}],
		buttons : [{
			text : '保存',
			iconCls : 'Pagesave',
			handler : function() {
				if (changePwdForm.getForm().isValid()) {
					if ((Ext.get("newPwd").dom.value != Ext.get("newPwdConfirm").dom.value)) {
						Ext.Msg.alert("提示", "确认密码与新密码不一致!");
						return false;
					}
					changePwdForm.getForm().submit({
						method : 'post',
						url : ctx+'/changePassword',
						//waitMsg : '正在修改密码,请等待...',
						waitTitle : '请等待...',
						success : function(form, action) {
							var result = eval('(' + action.response.responseText + ')');
							Ext.Msg.alert('提示', result.msg);
							changePwdWin.hide();
						},
						failure : function(form, action) {
							if (action.failureType == "connect") {
								Ext.Msg.alert('服务器异常', '服务器异常，请与管理员联系！');
							} else {
								var message = eval('(' + action.response.responseText + ')');
								Ext.MessageBox.show({
											title : '提示',
											msg : '数据保存失败！'+ message.msg
										});
							}
						}
					});
				}
			}
		},{
			text : '取消',
			iconCls : 'Arrowredo',
			handler : function() {
				changePwdWin.hide();
			}}]
	}]
});

var changePwdWin = new Ext.Window({
			width : 500,
			height : 220,
			closeAction : 'hide',
			items : [changePwdForm]
		});

//修改密码
function modifyPwd(){
	changePwdWin.show();
	changePwdForm.getForm().reset();
}

//消息弹出框
Ext.onReady(function() {

	var msgHtml='<div style="tip"><a href="#" class="tipA">1.这是系统消息</a></div>';

	new Ext.ux.TipWindow({
				title : '<span style="font-size:12px;">提示<a class="tipA" href="#">[5]<a/></span>',
				html : msgHtml,
				iconCls : 'Comments'
			}).show(Ext.getBody());
});

//开始执行
Ext.onReady(function() {
	Ext.QuickTips.init();
	Ext.apply(Ext.QuickTips.getQuickTip(), {
	    minWidth: 100
	});


//var homeUrl=ctx+"/views/frameset/ihome";
var homeUrl="http://www.baidu.com";
var mainTabs = new Ext.TabPanel({
    region:'center',
    activeTab:0,
    id:'mainTabs',
    plugins : new Ext.ux.TabCloseMenu(),
    enableTabScroll:true,
    height:docHeight-85,
    border:false,
    frame:true,
    items:[{
          title:"首页",
          xtype : "panel",
         // html:"<iframe name='mainFrame'  src='http://www.baidu.com' scrolling='auto' frameborder='0' width='100%' height='100%' ></iframe>"
          html:"<iframe id='mainFrame' name='mainFrame'  src='"+ homeUrl +"' scrolling='auto' frameborder='0' width='100%' height='100%' ></iframe>"
    }]
 });

/**
 * 响应树节点单击事件
 */
function addTab(url, name, menuid, pathCh, icon) {
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
								Ext.getCmp('centerPanel').setTitle(pathCh);
							}}
					});
		}
		mainTabs.setActiveTab(n);
	}
}

var menuPanel=new Ext.Panel({
		region:'west',
        width: 220,
        minSize: 200,
        maxSize: 350,
        split: true,
        animate:false,
        autoScroll : false,
        defaultType :'treepanel',
        layout:'accordion',
        layoutConfig:{
          animate:true,
		  activeOnTop : false
		}
	 });



//发送ajax请求获取菜单数据
function getMenuData(pid){
	var menuData;
	 $.ajax({
		type: "post",
		url: ctx+"/sysMenu/getChildList",
		dataType:"json",
        async:false,
		data:{
				node: pid
              },
	     cache :false,
         success: function(result){
			menuData=result;
		}
	});
	return menuData;
}

var menuData=getMenuData(0);


for(var i=0;i<menuData.length;i++){
	  var menuId=menuData[i].id;
	  var menuTitle=menuData[i].text;
	  //menuData[i].iconCls
	  var menuIconCls=menuData[i].iconCls;

	  var tree = new Ext.tree.TreePanel({
			title :menuTitle,
			iconCls :menuIconCls,
			lines:false,
			width : 200,
			rootVisible : false,
			root :  new Ext.tree.AsyncTreeNode({text : '<span>'+menuTitle+'</span>',id:menuId}),
			animate : true,
			enableDD : false,
			border : false,
			containerScroll : true,
			loader : new  Ext.tree.TreeLoader({
						dataUrl : ctx+ '/sysMenu/getChildList',
						requestMethod : 'post',
			            clearOnLoad : true
					}),
			listeners :{
				'beforeload':function(node) {
					//this.getLoader().dataUrl = ctx+ '/sysCFls/getMainPageMenu?pid='+node.id;
				},
				'click' : function(node,e){
					//阻止node的链接事件
					e.stopEvent();
					addTab(ctx+node.attributes.href,node.text,node.id,node.attributes.menuPath,'1.png');
			     }

		}});
		menuPanel.add(tree);
}

//$('span').css('color','red');
//$('.x-tree-node').css('color','red');

var imgUrl=ctx+"/resources/images/jpanda.png";
var viewport=new Ext.Viewport({
			layout : 'border',
			items : [{
						region : 'north',
						//title:'dms',
						//contentEl:'north',
					    height:68,
					    autoHeight : true,
					    border : false,
					    margins : '0 0 0 0',
					    /***
						html : "<div id=\"north\">\n" +
							"<div class=\"TopBox\">\n" +
							"  <div class=\"TopRightBox\">\n" +
							"    <div class=\"AlignBottom\">\n" +
							"      <a href=\"#\" class=\"exit\">&nbsp;</a>\n" +
							"      <a href=\"#\" class=\"modifyPass\" onclick=\"closeWindow()\">&nbsp;</a>\n" +
							"    </div>\n" +
							"  </div>\n" +
							"  <div class=\"TopLogo\"></div>\n" +
							"</div>\n" +
							"</div>" ***/
					    html:"<table style=\"background-color:RGB(242,247,254);\" width=\"100%\"   border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"headTable\">\n" +
				    	 "  <tr >\n" +
				    	"    <td width=\"454\" height=\"68\" >&nbsp;" +
				    	"        <div style=\"position:absolute;left:20px;top:20px;color:#15428b;font-size:26px;font-family:KaiTi;font-weight:bold;\">" +
				    	"			<img  style=\"margin-bottom:-6px;\" src=\""+imgUrl+"\">" +
				    	"			<span style=\"margin-left:-6px;\">用户管理系统</span>" +
				    	"       </div>\n" +
				    	"    </td>\n" +
				    	"    <td align=\"right\" ><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
				    	"      <tr>\n" +
				    	"        <td  align=\"right\" ><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
				    	"          <tr>\n" +
				    	"            <td width=\"70\" style=\"font-family:KaiTi;font-size:16px\" height=\"78\" align=\"left\"><a onclick=\"modifyPwd()\" href=\"javascript:void(0)\" >修改密码</a></td>\n" +
				    	"            <td width=\"70\" style=\"font-family:KaiTi;font-size:16px\" height=\"78\" align=\"left\"><a onclick=\"relogin()\" href=\"javascript:void(0)\" >重新登录</a></td>\n" +
				    	"            <td width=\"90\" style=\"font-family:KaiTi;font-size:16px\" align=\"left\"><a onclick=\"doExit()\" href=\"javascript:void(0)\">退出系统</a></td>\n" +
				    	"          </tr>\n" +
				    	"        </table></td>\n" +
				    	"      </tr>\n" +
				    	"    </table></td>\n" +
				    	"  </tr>"
					},{
						region : 'west',
						collapsible : true,
						title : '系统导航',
						iconCls:'Bookpreviousarrow',
						width : 200,
						split : true,
						layout : 'fit',
						items:[menuPanel],
						listeners:{
					      	'expand':function(){
					      		//刷新
					      		//document.getElementById('mainFrame').contentWindow.location.reload(true);
					      		//document.getElementById('mainFrame').style.width=document.body.clientWidth-210;
					      		//调用方法
					      		//mainFrame.window.refresh();
					        },
					        'collapse':function(){
					        	// document.getElementById('mainFrame').contentWindow.location.reload(true);
					        	//document.getElementById('mainFrame').style.width=document.body.clientWidth+210;
					        	//mainFrame.window.refresh();
					        }
					    }
					},
					{
						region : 'center',
						 id: 'centerPanel',
					     autoScroll:false,
	                     layout: 'fit',
	                     //title:'&nbsp;', //去除panel上标题,面包屑导航
	                     items:[mainTabs]
					}
					/**
					, {
						region : 'south',
						collapsible : true,
						html : '<div >'+
									'<table width="100%">'+
										'<tr>'+
											'<td style="text-align:left"><div class="main-root"><MARQUEE scrollAmount="2" direction="left">&nbsp;&nbsp;欢迎您!</MARQUEE></div></td>'+
											'<td style="text-align:right"><div class="main-root">Copyright© 2014 wuyechun 中国.合肥&nbsp;</div></td>'+
										'</tr>'+
									'</table>'+
								'</div>',
						split : true,
						height : 0
						//minHeight : 20
					}
					**/
					]
		});

});
//getCmp方法用来获得一个Ext组件，也就是一个已经在页面中初始化了的Component或其子类的对象，getCmp方法中只有一个参数，也就是组件的id。