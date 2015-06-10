/**
 * @class  Ext.form.TextField
 * @override  Ext.form.TextField
 * @description  unitText用于验证显示
 */
Ext.override(Ext.form.TextField, {
	unitText : '',
	onRender : function(ct, position) {
		Ext.form.TextField.superclass.onRender.call(this, ct,position);
		// 如果单位字符串已定义 则在后方增加单位对象
		if (this.unitText != '') {
			this.unitEl = ct.createChild({
						tag : 'div',
						html : this.unitText
					});
			this.unitEl.addClass('x-form-unit');
			this.alignErrorIcon = function() {
				this.errorIcon.alignTo(this.unitEl, 'tl-tr', [2, 0]);
			};
		}
	}
});




