var currentPage = 1;
var pageCount = 10;
var fId = "";
var oldForm = new Array();
var pageSize = [10,25,50,100];
// 动态创建页标签
function createPager(page,formId) {
	//隐藏原分页标签
	$(".dataTables_filter").hide();
	$("#bigDataList_length").hide();
	$("#bigDataList_info").hide();
	$("#bigDataList_paginate").hide();
    if (page == null) {
        return;
    }
    currentPage = Number(page.pageNum);
    pageCount = Number(page.pages);
    fId = formId;
    var pagerHtml = '';
    pagerHtml += '<div class="invest_page black2"><div class="page">';
    pagerHtml += '每页<select id="xznumPerPage" style="width:50px;height:20px;display:inline-block;padding-top:1px;padding:0;margin-right:5px;" onChange="javascript:numPerPageChange();">';
    for(var i=0;i<pageSize.length;i++){
    	if(page.pageSize == pageSize[i]){
    		pagerHtml += '<option value="'+pageSize[i]+'" selected="selected">'+pageSize[i]+'</option>';
    	}else{
    		pagerHtml += '<option value="'+pageSize[i]+'">'+pageSize[i]+'</option>';
    	}
    }
    pagerHtml += '</select>条&nbsp;&nbsp;&nbsp;';
    
    var pageNumber = 1;
    if(currentPage <= pageCount){
    	pageNumber = currentPage;
    }
    pagerHtml += '跳转到第<input type="number" id="xzpageNum" name="xzpageNum" style="width:40px;height:20px;display:inline-block;padding:0;text-align:center;margin:0 5px" value="'+pageNumber+'" />页';
    pagerHtml += '<input type="button" value="GO" style="width:40px;height:20px;display:inline-block;padding:0;margin-left:5px;color: #fff;background-color: #1caf9a;border-color: #1caf9a;" onclick="javascript:xzpageNum();"/>&nbsp;&nbsp;&nbsp;';
    if (currentPage > 1) {
        pagerHtml += '<a href="javascript:jumpPage(' + (currentPage - 1)
            + ',\''+formId+'\');">上一页</a>';
    } else {
        pagerHtml += '<a href="javascript:;" class="disabled">上一页</a>';
    }

    var showTotalPageNum = 8;
    if (pageCount > showTotalPageNum) {
        // 在第四页和倒数第四页之间
        if (currentPage > 4 && currentPage <= pageCount - 4) {
            pagerHtml += '<a href="javascript:jumpPage(1,\''+formId+'\');">1</a>';
            pagerHtml += '<span>...</span>';
            pagerHtml += '<a href="javascript:jumpPage(' + (currentPage - 2)
                + ',\''+formId+'\');">' + (currentPage - 2) + '</a>';
            pagerHtml += '<a href="javascript:jumpPage(' + (currentPage - 1)
                + ',\''+formId+'\');">' + (currentPage - 1) + '</a>';
            pagerHtml +=  currentPage;
            pagerHtml += '<a href="javascript:jumpPage(' + (currentPage + 1)
                + ',\''+formId+'\');">' + (currentPage + 1) + '</a>';
            pagerHtml += '<a href="javascript:jumpPage(' + (currentPage + 2)
                + ',\''+formId+'\');">' + (currentPage + 2) + '</a>';
            pagerHtml += '<span>...</span>';
            pagerHtml += '<a href="javascript:jumpPage(' + pageCount + ',\''+formId+'\');">'
                + pageCount + '</a>';
            // 第四页之前
        } else if (currentPage <= 4) {
            for (var i = 1; i <= 4; i++) {
                if (i == currentPage) {
                	pagerHtml +=  i;
                } else {
                    pagerHtml += '<a href="javascript:jumpPage(' + i + ',\''+formId+'\');">'
                        + i + '</a>';
                }
            }
            if (currentPage == 3) {
                pagerHtml += '<a href="javascript:jumpPage(5,\''+formId+'\');">5</a>';
            }
            if (currentPage == 4) {
                pagerHtml += '<a href="javascript:jumpPage(5,\''+formId+'\');">5</a>';
                pagerHtml += '<a href="javascript:jumpPage(6,\''+formId+'\');">6</a>';
            }

            pagerHtml += '<span>...</span>';
            pagerHtml += '<a href="javascript:jumpPage(' + pageCount + ',\''+formId+'\');">'
                + pageCount + '</a>';
            // 倒数第四页之后
        } else if (currentPage > pageCount - 4) {
            pagerHtml += '<a href="javascript:jumpPage(1,\''+formId+'\');">1</a>';
            pagerHtml += '<span>...</span>';

            if (currentPage == pageCount - 2) {
                pagerHtml += '<a href="javascript:jumpPage(' + (pageCount - 4)
                    + ',\''+formId+'\');">' + (pageCount - 4) + '</a>';
            }

            if (currentPage == pageCount - 3) {
                pagerHtml += '<a href="javascript:jumpPage(' + (pageCount - 5)
                    + ',\''+formId+'\');">' + (pageCount - 5) + '</a>';
                pagerHtml += '<a href="javascript:jumpPage(' + (pageCount - 4)
                    + ',\''+formId+'\');">' + (pageCount - 4) + '</a>';
            }

            for (var i = pageCount - 3; i <= pageCount; i++) {
                if (i == currentPage) {
                    pagerHtml +=  i;
                } else {
                    pagerHtml += '<a href="javascript:jumpPage(' + i + ',\''+formId+'\');">'
                        + i + '</a>';
                }
            }
        }
        // 小于页数限额
    } else {
        for (var i = 1; i <= pageCount; i++) {
            if (i == currentPage) {
                pagerHtml += i;
            } else {
                pagerHtml += '<a href="javascript:jumpPage(' + i + ',\''+formId+'\');">' + i
                    + '</a>';
            }
        }
    }

    if (pageCount >= currentPage + 1) {
        pagerHtml += '<a href="javascript:jumpPage(' + (currentPage + 1)
            + ',\''+formId+'\');">下一页</a>';
    } else {
        pagerHtml += '<a href="javascript:;" class="disabled">下一页</a>';
    }

    pagerHtml += '</div></div>';
    /*console.log(pagerHtml);*/
    $("#" + formId).append("<input type='hidden' id='numPerPage' name='numPerPage' value='"+page.pageSize+"'/>");
    $("#" + formId).append("<input type='hidden' id='pageNum' name='pageNum' value='1'/>");
    $("#" + formId).append("<input type='hidden' id='xzOldPageNum' name='xzOldPageNum' value='"+pageNumber+"'/>");
    //初始化form数据
    initOldForm();
    return pagerHtml;
}

function jumpPage(page,formId) {
	var a = $("#"+formId).serializeArray();
	for(var i=0;i<a.length;i++){
		if(a[i].name != "numPerPage" && a[i].name != "pageNum" && a[i].name != "xzOldPageNum"){
			$("#"+a[i].name).val(oldForm[i].value);
		}
	}
	$("#pageNum").val(page);
	$("#"+formId).append("<input type='hidden' name='tmp' value='" + Math.round(Math.random()*100000) + "'/>");
    $("#" + formId).submit();
}
function cleanAll(formId){
	   $("#"+formId+" :input").not(":button, :submit, :reset, :hidden").val("").removeAttr("checked").remove("selected");//核心 
}
function initOldForm(){
	var a = $("#"+fId).serializeArray();
	for(var i=0;i<a.length;i++){
		var obj = {};
		obj.name = a[i].name;
		obj.value = a[i].value;
		oldForm.push(obj);
	}
	sessionStorage.setItem("oldFormInfos",$("#"+fId).serialize());
}
function numPerPageChange(){
	$("#numPerPage").val($("#xznumPerPage").val());
	jumpPage(1,fId);
}
function xzpageNum(){
	var xzpageNum = $("#xzpageNum").val();
	if(xzpageNum <= pageCount){
		jumpPage(xzpageNum,fId);
	}
}

function editStatus(fromId){
	var xzpageNum = $("#xzpageNum").val();
	if(xzpageNum <= pageCount){
		jumpPage(xzpageNum,fromId);
	}
}
