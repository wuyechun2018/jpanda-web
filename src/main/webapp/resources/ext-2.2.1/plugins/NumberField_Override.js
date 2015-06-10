Ext.override(Ext.form.NumberField, {
	baseChars : "0123456789,",
	style : 'text-align:right',
	decimalPrecision : 4,
	value : '0.0000',
	setValue : function(v) {
		v = typeof v == 'number' ? v : String(v).replace(this.decimalSeparator,
				".").replace(/,/g, "");
		// v = isNaN(v) ? '' : String(v).replace(".", this.decimalSeparator);
		v = isNaN(v) ? '' : Ext.util.Format.number(
				this.fixPrecision(String(v)), "0,000,000.0000");
		this.setRawValue(v);
		return Ext.form.NumberField.superclass.setValue.call(this, v);
	},
	fixPrecision : function(value) {
		var nan = isNaN(value);
		if (!this.allowDecimals || this.decimalPrecision == -1 || nan || !value) {
			return nan ? '' : value;
		}
		return parseFloat(value).toFixed(this.decimalPrecision);
	},
	validateValue : function(value) {
		if (!Ext.form.NumberField.superclass.validateValue.call(this, value)) {
			return false;
		}
		if (value.length < 1) { // if it's blank and textfield didn't flag it
			// then it's valid
			return true;
		}
		value = String(value).replace(this.decimalSeparator, ".").replace(/,/g,
				"");
		if (isNaN(value)) {
			this.markInvalid(String.format(this.nanText, value));
			return false;
		}
		var num = this.parseValue(value);
		if (num < this.minValue) {
			this.markInvalid(String.format(this.minText, this.minValue));
			return false;
		}
		if (num > this.maxValue) {
			this.markInvalid(String.format(this.maxText, this.maxValue));
			return false;
		}
		return true;
	},
	parseValue : function(value) {
		value = parseFloat(String(value).replace(this.decimalSeparator, ".")
				.replace(/,/g, ""));
		return isNaN(value) ? '' : value;
	}
});