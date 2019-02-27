// JavaScript Document
var ohtml = document.documentElement;
getSize();

window.onresize = function(){
    getSize();
}
function getSize(){

    var screenWidth = ohtml.clientWidth;
    if(screenWidth <= 320){
        ohtml.style.fontSize = '17px';
    }else if(screenWidth >= 750){
        ohtml.style.fontSize = '40px';
    }else{
        ohtml.style.fontSize = screenWidth/(750/40)+'px';
    }
    
}


//设置全系统查询条件数据缓存
var base = {
	baseDetail : function(fromId,url){
		var fromInfo = sessionStorage.getItem("oldFormInfos");
		sessionStorage.setItem("detailId",fromInfo);
		window.location.href = url;
	},
	quitParent : function(url){
		var formParams = base.setWhere();
		if(url.indexOf("?") > -1){
			url += "&" + formParams;
		}else{
			url += "?" + formParams
		}
		window.location.href = url;
	},
	setWhere : function(){
		var formParams = sessionStorage.getItem("detailId");
		var forms = formParams.split("&");
		var temp = "";
		var where = "";
		for(var i=0;i<forms.length;i++){
			var params = forms[i].split("=");
			if(params[0] == "xzOldPageNum"){
				temp = params[1];
			}
		}
		for(var i=0;i<forms.length;i++){
			var params = forms[i].split("=");
			if(params[0] == "pageNum"){
				where +=params[0]+"="+ temp + "&";
			}else{
				where +=forms[i] + "&";
			}
		}
		console.log(where);
		where = where.substring(0,where.length-1);
		console.log(where);
		return where;
	}
}