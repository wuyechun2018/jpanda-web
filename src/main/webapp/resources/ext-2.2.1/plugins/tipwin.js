/**
 * 右下角滑出提示窗口
 */
Ext.namespace("Ext.ux");
Ext.ux.TipWindowMgr = {
	positions : []
};
Ext.ux.TipWindow = Ext.extend(Ext.Window, {
			initComponent : function() {
				Ext.apply(this, {
							iconCls : this.iconCls || 'Comments',
							width : 250,
							height : 165,
							autoScroll : true,
							autoDestroy : true,
							plain : false,
							bodyStyle : 'background-color:#FFFFFF;font-size: 13px;',
							shadow : false
						});
				this.task = new Ext.util.DelayedTask(this.hide, this);
				Ext.ux.TipWindow.superclass.initComponent.call(this);
			},
			setMessage : function(msg) {
				this.body.update(msg);
			},
			setTitle : function(title, iconCls) {
				Ext.ux.TipWindow.superclass.setTitle.call(this, title,
						iconCls || this.iconCls);
			},
			onRender : function(ct, position) {
				Ext.ux.TipWindow.superclass.onRender.call(this, ct, position);
			},
			onDestroy : function() {
				Ext.ux.TipWindowMgr.positions.remove(this.pos);
				Ext.ux.TipWindow.superclass.onDestroy.call(this);
			},
			afterShow : function() {
				Ext.ux.TipWindow.superclass.afterShow.call(this);
				this.on('move', function() {
							Ext.ux.TipWindowMgr.positions.remove(this.pos);
							this.task.cancel();
						}, this);
				//15s后自动关闭
				this.task.delay(5000*3);
			},
			animShow : function() {
				this.pos = 0;
				while (Ext.ux.TipWindowMgr.positions.indexOf(this.pos) > -1)
					this.pos++;
				Ext.ux.TipWindowMgr.positions.push(this.pos);
				//窗口大小
				this.setSize(250, 165);
				//窗口位置
				this.el.alignTo(document, "br-br",[-5, -20 - ((this.getSize().height + 10) * this.pos)]);
				this.el.slideIn('b', {
							duration : 2,
							callback : this.afterShow,
							scope : this
						});
			},
			animHide : function() {
				Ext.ux.TipWindowMgr.positions.remove(this.pos);
				this.el.ghost("b", {
							duration : 2,
							remove : true,
							scope : this,
							callback : this.destroy
						});
			}
});