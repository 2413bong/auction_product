/**
 * 
 */
var AjaxUtil = function(conf){ 
	var xhr = new XMLHttpRequest(); 
	var url = conf.url;
	var method = conf.method?conf.method:'GET';
	var param = conf.param?conf.param:'{}';
	
	var success= conf.success?conf.success:function(res){
		alert(res);
	}
	var error = conf.error?conf.error:function(res){
		alert(res);
	}
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status=="200"){
				success(xhr.responseText);
			}else{
				error(xhr.responseText);
			}
		}
	}
	xhr.open(method,url);
	if(method!="GET"){
		xhr.setRequestHeader('Content-type','application/json;charset=utf-8');
	}
	this.send=function(){
		xhr.send(param);
	}
}