Ext.onReady(function() {

	var selectTreeNode;

	//复选框
	var citySm = new Ext.grid.CheckboxSelectionModel({
		header : "",
		singleSelect : false
	});

	//行号
	var cityRnum = new Ext.grid.RowNumberer({
		header : '序号',
		width : 35
	});

	//记录
	var cityRecord = new Ext.data.Record.create([{
		name : 'id'
	},{
		name : 'cityCode'
	},{
		name : 'cityName'
	}, {
		name : 'provinceCode'
	}, {
		name : 'provinceName'
	},{
		name : 'coordinate'
	}, {
		name : 'orderby'
	}]);

	//列定义
	var cityCm = new Ext.grid.ColumnModel([ citySm, cityRnum, {
		header : '主键',
		dataIndex : 'id',
		sortable : false,
		hidden : true
	},{
		header : '城市名称',
		dataIndex : 'cityName',
		sortable : false,
		align : 'left'
	},{
		header : '省份',
		dataIndex : 'provinceName',
		sortable : false,
		hidden : false,
		align : 'center',
		width : 80
	},{
		header : '城市编码',
		dataIndex : 'cityCode',
		align : 'center',
		sortable : false,
		width : 100
	},{
		header : '地理坐标',
		dataIndex : 'coordinate',
		sortable : false,
		width : 150
	},{
		header : '排序',
		dataIndex : 'orderby',
		sortable : false,
		width : 50,
		align : 'center'
	}  ]);

	//数据源
	var cityDs = new Ext.data.Store({
		proxy : new Ext.data.HttpProxy({
			url : ctx + '/sysCity/list'
		}),
		reader : new Ext.data.JsonReader({
			root : 'list',
			totalProperty : 'totalCount'
		}, cityRecord)
	});

	//查询框
	var searchText = new Ext.form.TextField({
		id : 'queryParam',
		name : 'queryParam',
		emptyText : '',
		enableKeyEvents : true,
		width : 130,
		listeners : {
			specialkey : function(field, e) {
				if (e.getKey() == Ext.EventObject.ENTER) {
					doSearch();
				}
			}
		}
	});

	//查询方法
	function doSearch(){
		//城市编码
		var provinceCode=selectTreeNode==null?'':selectTreeNode.attributes.bizKey;

		cityDs.baseParams = {
				searchKey:searchText.getValue(),
				provinceCode:provinceCode
			};
		cityDs.load({
			params : {
				start : 0,
				limit : 30
			}
		});
	}

	//页面打开时执行查询方法
	doSearch();

	//新增表单
	var addForm =new Ext.form.FormPanel({
		labelWidth : 80,
		frame : true,
		defaultType : 'textfield',
		labelAlign : 'right',
		bodyStyle : 'padding:5 5 5 5',
		layout : 'form',
		autoScroll : true,
		items : [{
					id : 'id',
					xtype : 'hidden',
					name : 'id',
					hidden:true
				}, {
					xtype : 'hidden',
					id : 'provinceCode',
					name : 'provinceCode',
					anchor : '90%'
				}, {
					fieldLabel : '省份',
					id : 'provinceName',
					name : 'provinceName',
					allowBlank : false,
					unitText : '<font color=red>*</font>',
					anchor : '90%'
				}, {
					fieldLabel : '城市编码',
					name : 'cityCode',
					allowBlank : false,
					unitText : '<font color=red>*</font>',
					anchor : '90%'
				}, {
					fieldLabel : '城市名称',
					name : 'cityName',
					allowBlank : false,
					unitText : '<font color=red>*</font>',
					anchor : '90%'
				}, {
					fieldLabel : '地理坐标',
					name : 'coordinate',
					allowBlank : false,
					unitText : '<font color=red>*</font>',
					anchor : '90%'
				},{
					fieldLabel : '排序',
					name : 'orderby',
					xtype : 'numberfield',
					allowDecimals : false,
					allowNegative : false,
					maxValue : 999999,
					minValue : 0,
					anchor : '90%'
				}],
				buttons : [{
					text : '保存',
					iconCls : 'Pagesave',
					handler : function() {
						saveCity();
					}
				}, {
					text : '取消',
					iconCls : 'Arrowredo',
					handler : function() {
						addWindow.hide();
					}
				}]
	});

	//保存城市
	function saveCity(){
		if (addForm.getForm().isValid()) {
			addForm.getForm().submit({
				url : ctx+'/sysCity/save',
				method : 'post',
				params : {

				},
				success : function(form, action) {
					Ext.MessageBox.alert('提示', action.result.msg);
					addWindow.hide();
					doSearch();
				},
				failure : function(form, action) {
					var result = eval('('+ action.response.responseText+ ')');
					Ext.MessageBox.show({title : '错误',msg : '数据保存失败！' + result.msg});
				}
			});
		}
	}

	//新增弹出框
	var addWindow = new Ext.Window({
		title : '新增城市',
		layout : 'fit',
		width : 500,
		autoScroll : true,
		height : 320,
		closable : true,
		collapsible : true,
		maximizable : true,
		border : false,
		constrain : true,
		closeAction : 'hide',
		items : [addForm]
	});

	//新增按钮
	var addBtn =  new Fw.ux.Button.AddBtn({
		handler : function() {
			if(selectTreeNode==null){
				Ext.Msg.alert("提示","请选择省份!");
				return;
			}
			var provinceCode=selectTreeNode.attributes.bizKey;
			//清空表单
			addForm.getForm().reset();
			Ext.getCmp('provinceCode').setValue(provinceCode);
			Ext.getCmp('provinceName').setValue(selectTreeNode.text);
			addWindow.setTitle('新增城市');
			addWindow.show();
		}
	});

	//删除按钮
	var deleteBtn =new Fw.ux.Button.DeleteBtn({
				handler : function() {
					var selectedRows = cityGrid.getSelectionModel().getSelections();
					if (selectedRows.length > 0) {
						var ids = "";
						Ext.Msg.confirm('提示','删除的数据您将不能恢复,确定要删除吗?',function(value) {
											if (value == 'yes') {
												//处理多选
												for ( var i = 0; i < selectedRows.length; i++) {
													ids += selectedRows[i].data.id+ ",";
												}
												if (ids.length > 0) {
													ids = ids.substring(0,ids.length - 1);
												}
												Ext.Ajax.request({
															url : ctx+ '/dmsSystem/delete',
															params : {
																ids : ids
															},
															method : 'post',
															waitMsg : '正在删除数据,请等待...',
															waitTitle : '请等待...',
															success : function(response,options) {
																var result = eval("("+ response.responseText+ ")");
																Ext.Msg.alert("提示",result.msg);
																doSearch();
															},
															failure : function(response,options) {
																var result = eval("("+ response.responseText+ ")");
																Ext.Msg.alert("提示",result.msg);
															}
														});
											}
										});
					} else {
						Ext.Msg.alert('提示', '请选择您要删除的记录!');
					}

				}
			});


	/**
	 * 修改初始化表单
	 */
	function updateInit(){
		var record = cityGrid.getSelectionModel().getSelected();
		if (Ext.isEmpty(record)) {
			Ext.MessageBox.alert('提示', '请先选择要修改的记录!');
			return;
		}
		addWindow.show();
		addForm.getForm().loadRecord(record);
		addWindow.setTitle('修改城市');
	}

	/**
	 * 修改按钮
	 */
	var updateBtn = new Fw.ux.Button.UpdateBtn({
		handler : function() {
			updateInit();
		}
	});

	/**
	 * 查询按钮
	 */
	var searchBtn = new Fw.ux.Button.QueryBtn({
		handler : function() {
			doSearch();
		}
	});

	//分页
	var cityBbar = new Ext.PagingToolbar({
		pageSize : 30,
		store : cityDs,
		displayInfo : true,
		displayMsg : '显示第 {0} 条到 {1} 条记录，一共 {2} 条',
		emptyMsg : "没有记录"
	});

	//工具栏
	var cityTbar = new Ext.Toolbar({
		items : [addBtn,'-',deleteBtn,'-',updateBtn,'-',searchText,searchBtn]
	});

	//表格
	var cityGrid = new Ext.grid.GridPanel({
		sm : citySm,
		cm : cityCm,
		ds : cityDs,
		enableHdMenu:false,
		stripeRows : true, //斑马线
		bbar : cityBbar,
		frame:false,
		tbar : cityTbar,
		viewConfig : {
			forceFit : true
		}
	});

	// 监听行双击事件
	cityGrid.on('rowdblclick', function(pGrid, rowIndex, event) {
		updateInit();
	});


//根节点
var root = new Ext.tree.AsyncTreeNode({
	id : '0',
	text : '全国省份',
	expanded : true
});

var provinceTree = new Ext.tree.TreePanel({
		border:false,
		width : 210,
		useArrows : false,
		root : root,
		height : 500,
		autoScroll : true,
		animate : false,
		loader : new Ext.tree.TreeLoader({
			dataUrl : ctx+ '/sysProvince/getPorvinceList'
		}),
		listeners :{
			'click' : function(node,e){
				selectTreeNode=node;
				doSearch();
			}
		}
	});

var viewport = new Ext.Viewport({
		layout : 'border',
		items : [ {
			title : '城市列表',
			collapsible : true,
			width : 210,
			layout : 'fit',
			minSize : 160,
			maxSize : 280,
			split : true,
			region : 'west',
			frame:false,
			autoScroll : false,
			margins : '0 0 0 0',
			items:[provinceTree]
		}, {
			region : 'center',
			layout : 'fit',
			collapsible : true,
			frame:false,
			border : false,
			margins : '0 0 0 0',
			items:[cityGrid]
		} ]
	});
});