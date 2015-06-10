Ext.override(Ext.data.Connection, {
	  handleResponse : function(response){
	        this.transId = false;
	        var options = response.argument.options;
	        response.argument = options ? options.argument : null;
	        this.fireEvent("requestcomplete", this, response, options);
	        
	        if(response.getResponseHeader&&response.getResponseHeader.SessionNull){
		          Ext.Msg.alert("系统提示",'会话已过期,请重新登录！',function(e){   	
	        		if(e=="ok"){
		           			window.location.href=response.getResponseHeader.SessionNull;
		           		}
		           }); 
		          
		    }else if(response.getResponseHeader&&response.getResponseHeader.Exception){
	           Ext.Msg.alert("系统提示",'请求出现错误!'); 
	        }else{
		        var respob=Ext.decode(response.responseText);
		        if(respob&&respob.hasOwnProperty("success")&&!respob.success){
		          Ext.Msg.alert("系统提示",respob.msg?respob.msg:'请求出现错误!');         
		        }else{
		          Ext.callback(options.success, options.scope, [response, options]);
		        }
	        }
	        Ext.callback(options.callback, options.scope, [options, true, response]);
	    },
	 handleFailure : function(response, e){		
	        this.transId = false;
	        var options = response.argument.options;
	        response.argument = options ? options.argument : null;
	        this.fireEvent("requestexception", this, response, options, e);
	        Ext.Msg.alert("系统提示",'服务正进行维护,请联系系统管理员.');
	        Ext.callback(options.failure, options.scope, [response, options]);
	        Ext.callback(options.callback, options.scope, [options, false, response]);
	    }
});