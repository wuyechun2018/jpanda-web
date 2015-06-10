Ext.namespace("Fw.ux.Button");

Fw.ux.Button.AddBtn = Ext.extend(Ext.Button, {
			//minWidth : 65,
			text : '新增',
			iconCls : 'Applicationadd'
		});

Fw.ux.Button.UpdateBtn = Ext.extend(Ext.Button, {
			//minWidth : 65,
			text : '修改',
			iconCls : 'Applicationedit'
		});

Fw.ux.Button.DeleteBtn = Ext.extend(Ext.Button, {
			//minWidth : 65,
			text : '删除',
			iconCls : 'Applicationdelete'
		});

Fw.ux.Button.QueryBtn = Ext.extend(Ext.Button, {
			//minWidth : 65,
			text : '查询',
			iconCls : 'Zoom'
		});

Fw.ux.Button.RefreshBtn = Ext.extend(Ext.Button, {
			//minWidth : 65,
			text : '刷新',
			iconCls : 'Arrowrefresh'
		});


Fw.ux.Button.PauseBtn = Ext.extend(Ext.Button, {
	//minWidth : 65,
	text : '暂停',
	iconCls : 'Clockpause'
});


Fw.ux.Button.StopBtn = Ext.extend(Ext.Button, {
	//minWidth : 65,
	text : '停用',
	iconCls : 'Clockstop'
});



Fw.ux.Button.PlayBtn = Ext.extend(Ext.Button, {
	//minWidth : 65,
	text : '执行',
	iconCls : 'clockPlay'
});

Fw.ux.Button.SaveBtn = Ext.extend(Ext.Button, {
			///minWidth : 65,
			text : '保存',
			iconCls : 'Pagesave'
		});

Fw.ux.Button.CancelBtn = Ext.extend(Ext.Button, {
			//minWidth : 65,
			text : '取消',
			iconCls : 'Arrowredo'
		});

Fw.ux.Button.ExportBtn = Ext.extend(Ext.Button, {
	//minWidth : 65,
	text : '导出',
	iconCls : 'Pagewhiteexcel'
});

Fw.ux.Button.ResetBtn = Ext.extend(Ext.Button, {
	//minWidth : 65,
	text : '重置',
	iconCls : 'Arrowundo'
});

Fw.ux.Button.ViewBtn = Ext.extend(Ext.Button, {
	//minWidth : 65,
	text : '查看',
	iconCls : 'Monitor'
});

Fw.ux.Button.UpBtn = Ext.extend(Ext.Button, {
	//minWidth : 65,
	text : '上报',
	iconCls : 'Arrowup'
});

Fw.ux.Button.DownBtn = Ext.extend(Ext.Button, {
	//minWidth : 65,
	text : '退回',
	iconCls : 'Arrowdown'
});

Fw.ux.Button.AuditBtn = Ext.extend(Ext.Button, {
	//minWidth : 65,
	text : '审核',
	iconCls : 'Useredit'
});


Fw.ux.Button.CheckBtn = Ext.extend(Ext.Button, {
	//minWidth : 65,
	text : '核对',
	iconCls : 'Monitoredit'
});

Fw.ux.Button.LogOffBtn = Ext.extend(Ext.Button, {
	//minWidth : 65,
	text : '注销',
	iconCls : 'Stop'
});

Fw.ux.Button.ConfirmBtn = Ext.extend(Ext.Button, {
	//minWidth : 65,
	text : '确定',
	iconCls : 'Accept'
});



Ext.reg('addBtn', Fw.ux.Button.AddBtn);
Ext.reg('updateBtn', Fw.ux.Button.UpdateBtn);
Ext.reg('deleteBtn', Fw.ux.Button.DeleteBtn);
Ext.reg('queryBtn', Fw.ux.Button.QueryBtn);
Ext.reg('refreshBtn', Fw.ux.Button.RefreshBtn);
Ext.reg('saveBtn', Fw.ux.Button.SaveBtn);
Ext.reg('cancelBtn', Fw.ux.Button.CancelBtn);
Ext.reg('extportBtn', Fw.ux.Button.ExportBtn);
Ext.reg('viewBtn', Fw.ux.Button.ViewBtn);
Ext.reg('upBtn', Fw.ux.Button.UpBtn);
Ext.reg('downBtn', Fw.ux.Button.DownBtn);
Ext.reg('auditBtn', Fw.ux.Button.AuditBtn);
Ext.reg('resetBtn', Fw.ux.Button.ResetBtn);
Ext.reg('checkBtn', Fw.ux.Button.CheckBtn);
Ext.reg('logOffBtn', Fw.ux.Button.LogOffBtn);
Ext.reg('confirmBtn', Fw.ux.Button.ConfirmBtn);
Ext.reg('pauseBtn', Fw.ux.Button.PauseBtn);
Ext.reg('playBtn', Fw.ux.Button.PlayBtn);
Ext.reg('stopBtn', Fw.ux.Button.StopBtn);