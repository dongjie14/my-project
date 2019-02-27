var paginationMaxLength=10;//分页栏的最大显示条数
var onlyOnePageIsShow = true;//只有一页的时候是否显示
function paginationInit(){
    $('[pagination =pagination_new ]').each(function(){
        initPagination($(this));
    });
}
function isNeedPagination(totalpage,settingfromHTML){
    var condition ;
    if(settingfromHTML == "true"){
        condition = true;
    }else if(settingfromHTML == 'false'){
        condition = false;
    }else {
        condition = onlyOnePageIsShow;
    }
    if(condition && totalpage<1){
        return false;
    }else if(!condition && totalpage<=1){
        return false;
    }
    return true;
}
function setDisplayMaxLength(element,len){
    var currentpage =  Number(element.attr('pagenumber'));
    var totoalpage = Number(element.attr('totalpage'));
    if(checkParamIsPositiveInteger(len)){
        len = Number(len);
    }else{
        len =paginationMaxLength;
    }
    if(len<totoalpage){
        var temp1 = parseInt((len-1)/2);
        var temp2 = parseInt(len/2);
        if(temp1<temp2){
            var leftstart = currentpage - temp1;
            var rightend = currentpage + temp1 + 1;
        }else{
            var leftstart = currentpage - temp1;
            var rightend = currentpage + temp1;
        }
        if(leftstart<1){
            rightend +=(1-leftstart);
            leftstart = 1;
        }
        if(rightend>totoalpage){
            if(leftstart>1){
                leftstart -=(rightend-totoalpage);
            }
            rightend =totoalpage;
        }
        if(leftstart<1){
            leftstart=1
        }
        while(leftstart >1){
            element.children('div').children('span[value = '+(--leftstart)+']').css('display','none');
        }
        while(rightend <totoalpage){
            element.children('div').children('span[value = '+(++rightend)+']').css('display','none');
        }
    }
}
//根据页面pagenumber、my_totoalpage更新分页，参数element传的是分页的容器
function initPagination(element){
    element.html('');
    var pagenumber = element.attr('pagenumber');
    var totalpage = element.attr('totalpage');
    var pMaxLength = element.attr('paginationMaxLength');
    var onePageIsShow = element.attr('onlyOnePageIsShow');
    if(isNeedPagination(Number(totalpage),onePageIsShow)){
        var content = '<div><span value="0"><a href="javascript:void(0);">上一页</a></span>';
        var page = totalpage % 10 == 0 ? totalpage / 10 : (totalpage/10)+1;
        for(var i =1; i<=page;i++){
            content +='<span value="'+i+'"><a href="javascript:void(0);">'+i+'</a></span>'
        }
        content +='<span value="-1"><a href="javascript:void(0);">下一页</a></span></div>';
        element.append(content);
        element.children('div').children('span[value='+pagenumber+']').children('a').css("color","#000");
        setDisplayMaxLength(element,pMaxLength);
        addClickListener(element);
    }
}
function addClickListener(element){
    element.children('div').children('span').bind('click',function(){
        var temp = Number($(this).attr('value'));
        var pagenumber = Number($(this).parent().parent().attr('pagenumber'));
        var totalpage = Number($(this).parent().parent().attr('totalpage'));
        if(temp == 0){
        	if(pagenumber - 1 > 0){
        		$(this).parent().parent().attr('pagenumber',pagenumber-1);
        		paginationClick(element);
                initPagination(element);
        	}
        }else if(temp == -1){
            var page = totalpage % 10 == 0 ? totalpage / 10 : (totalpage/10)+1;
            if(pagenumber+1 <= page){
            	$(this).parent().parent().attr('pagenumber',pagenumber+1);
            	paginationClick(element);
                initPagination(element);
            }
        }else{
        	$(this).parent().parent().attr('pagenumber',temp);
        	paginationClick(element);
            initPagination(element);
        }
    })
}
function checkParamIsPositiveInteger(param){
    var reg = /^[1-9]+[0-9]*]*$/;
    return reg.test(param);
}

//用户需要自己实现的点击事件，参数为分页容器的id
function paginationClick(element){
	var queryMothed = element.attr("queryMothed");
	eval(queryMothed+"()");
}
$(function(){
    paginationInit();
});