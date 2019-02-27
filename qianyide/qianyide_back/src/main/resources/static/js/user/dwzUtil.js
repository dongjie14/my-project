/**
 * dialog提交回调函数
 * @param json
 */
/*function dialogAjaxDone(json){
 DWZ.ajaxDone(json);  
 //注意返回的JSON的数据结构  
 if (json.statusCode == DWZ.statusCode.ok){  
 if (json.navTabId){   
 //把指定navTab页面标记为需要“重新载入”。注意navTabId不能是当前navTab页面的  
 navTab.reloadFlag(json.navTabId);  

 } else {   
 //重新载入当前navTab页面  
 navTabPageBreak();  
 }
 if ("closeCurrentDialog" == json.callbackType) {  
 setTimeout(function(){$.pdialog.closeCurrent();}, 100);  //关闭当前对话框

 }else if ("closeCurrent" == json.callbackType) {  

 setTimeout(function(){navTab.closeCurrentTab();}, 100);  

 } else if ("forward" == json.callbackType) {  
 navTab.reload(json.forwardUrl);  

 }  

 }  
 }
 */
$.ajaxSetup({
    contentType: "application/x-www-form-urlencoded;charset=utf-8",
    dataType: "html",
    complete: function (XMLHttpRequest, textStatus) {
        var sessionstatus = XMLHttpRequest.getResponseHeader("statusCode");//通过XMLHttpRequest取得响应头，sessionstatus，  
        if (sessionstatus != null && sessionstatus == "301") {
            //如果超时就处理 ，指定要跳转的页面  
            window.location.reload();
        }
    }
}); 