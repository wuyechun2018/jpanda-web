Ext.onReady(function() {
//根节点
var root = new Ext.tree.AsyncTreeNode({
	id : '0',
	text : '全国省份',
	expanded : true
});

//点击节点,装载表单
function loadForm(id){
	Ext.Ajax.request({
		url : ctx + '/sysProvince/getProvince',
		params : {
			id : id
		},
		method : 'post',
		success : function(result, request) {
			//var resultObj = eval('(' + result.responseText + ')');
			var resultObj = Ext.util.JSON.decode(result.responseText);
			Ext.getCmp('id').setValue(resultObj.id);
			Ext.getCmp('provinceCode').setValue(resultObj.provinceCode);
			Ext.getCmp('provinceName').setValue(resultObj.provinceName);
			Ext.getCmp('orderby').setValue(resultObj.orderby);
		}
	})
}

//保存
function saveProvince(){
	if (provinceForm.getForm().isValid()) {
		provinceForm.getForm().submit({
			url : ctx+'/sysProvince/save',
			method : 'post',
			params : {

			},
			success : function(form, action) {
				root.reload();
				Ext.MessageBox.alert('提示', action.result.msg);
				provinceForm.getForm().reset();
				//Ext.getCmp('saveBtn').disable();
				//Ext.getCmp('resetBtn').disable();
			},
			failure : function(form, action) {
				var result = eval('('+ action.response.responseText+ ')');
				Ext.MessageBox.show({title : '错误',msg : '数据保存失败！' + result.msg});
			}
		});
	}
}

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
				e.stopEvent();
				if(node.id!=0){
					loadForm(node.id);
				}
				Ext.getCmp('saveBtn').disable();
				Ext.getCmp('resetBtn').disable();
			}
		}
	});


//表单
var provinceForm =new Ext.form.FormPanel({
	labelWidth : 80,
	frame : false,
	defaultType : 'textfield',
	labelAlign : 'right',
	bodyStyle : 'padding:5 5 5 5',
	layout : 'form',
	autoScroll : true,
	items : [{
		xtype : 'fieldset',
		id : 'formSet',
		labelAlign : 'right',
		labelWidth : 60,
		title : '省份信息',
		defaults : {
			//指定了每个表字段的宽度
			width : 350
		},
		defaultType : 'textfield',
		autoHeight : true,
		border : true,
		items : [{
				id : 'id',
				xtype : 'hidden',
				name : 'id',
				hidden:true
			}, {
				id:'provinceCode',
				fieldLabel : '省份编码',
				name : 'provinceCode',
				allowBlank : false,
				unitText : '<font color=red>*</font>'
			}, {
				id:'provinceName',
				fieldLabel : '省份名称',
				name : 'provinceName',
				allowBlank : false,
				unitText : '<font color=red>*</font>'
			},{
				fieldLabel : '排序',
				id:'orderby',
				name : 'orderby',
				xtype : 'numberfield',
				allowDecimals : false,
				allowNegative : false,
				maxValue : 99999,
				minValue : 0
			}],
			buttons : [{
				text : '保存',
				id:'saveBtn',
				iconCls : 'Pagesave',
				handler : function() {
					saveProvince();
				}
			}, {
				text : '取消',
				id:'resetBtn',
				iconCls : 'Arrowredo',
				handler : function() {
					provinceForm.getForm().reset();
				}
			}]
}]});

Ext.getCmp('saveBtn').disable();
Ext.getCmp('resetBtn').disable();

//右击事件
provinceTree.on('contextmenu',
		function(node, e) {
		    e.stopEvent();
		    var menu = new Ext.menu.Menu({
		        id: 'mainMenu',
		        items: [new Ext.menu.Item({
		            text: '添加',
		            iconCls: 'Applicationadd',
		            handler: function() {
		                node.expand();
		                Ext.getCmp('saveBtn').enable();
		                Ext.getCmp('resetBtn').enable();
		                provinceForm.getForm().reset();
		            }
		        }), new Ext.menu.Item({
		            text: '删除',
		            iconCls: 'Applicationdelete',
		            handler: function() {
		                // 有子节点,不能删除
		                if (node.childNodes.length > 0) {
		                    Ext.Msg.alert("提示", '该节点有子节点不可以直接删除！',
		                    function() {
		                        return;
		                    });
		                } else {
		                    Ext.Msg.confirm("提示", '确定要删除吗?',
		                    function(b) {
		                        if (b == 'yes') {
		                            Ext.Ajax.request({
		                                url: ctx + '/sysProvince/delete',
		                                params: {
		                                    id: node.id
		                                },
		                                method: 'post',
		                                success: function(result, request) {
		                                    var resultObj = Ext.util.JSON.decode(result.responseText);
		                                    Ext.MessageBox.alert('提示', resultObj.msg);
		                                    root.reload();
		                                    provinceForm.getForm().reset();
		                                }
		                            })
		                        }
		                    });
		                }
		            }
		        }), new Ext.menu.Item({
		            text: '修改',
		            iconCls: 'Applicationedit',
		            handler: function() {
		                e.stopEvent();
		                loadForm(node.id);
		                Ext.getCmp('saveBtn').enable();
		                Ext.getCmp('resetBtn').enable();
		            }
		        })]
		    });
		    var coords = e.getXY();
		    menu.showAt([coords[0], coords[1]]);
		},
		this);

var viewport = new Ext.Viewport({
		layout : 'border',
		items : [ {
			title : '省份列表',
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
			items:[provinceForm]
		} ]
	});
});