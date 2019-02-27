 //弹出框	
function popup(changeHtml,callback){
	var html='';
		html+='<div class="message-box animated fadeIn" id="commonPopup">';
		html+='<div class="nav col-md-6 nav-ul">';
		html+='<ul class="nav popup-ul bg-ul">';
		html+='<li>确认要'+changeHtml+'吗?</li>';
		html+='<li class="btn-li">';
		html+='<button type="button" class="btn btn-success active" id="sureid">确认</button>';
		html+='<button type="button" class="btn btn-default active" id="extid">取消</button>';
		html+='</li></ul></div></div>';
		$("body").prepend(html);
		$("#commonPopup").addClass("open");
		$("body").delegate("#sureid","click",function(){
			$("#commonPopup").removeClass("open");
			if( typeof callback === 'function' ){  
				callback();
			}
		});
		$("body").delegate("#extid","click",function(){
			$("#commonPopup").removeClass("open");
		});
}
//loading	
function loading(){
	var loadhtml='';
		loadhtml+='<div class="message-box animated fadeIn" id="loadPopup">';
		loadhtml+='<div class="loadEffect">';
		loadhtml+='<span></span>';
		loadhtml+='<span></span>';
		loadhtml+='<span></span>';
		loadhtml+='<span></span>';
		loadhtml+='<span></span>';
		loadhtml+='<span></span>';
		loadhtml+='<span></span>';
		loadhtml+='<span></span>';
		loadhtml+='</div>';
		loadhtml+='</div>';
		$("body").append(loadhtml);
		$("#loadPopup").addClass("open");
}
//隐藏loading
function hidden(){
	$("#loadPopup").remove();
	$("#loadPopup").removeClass("open");
	$(".dataTables_length").hide();
};
//alert弹框
function alertPopup(popupHtml,callback){
	var popuphtml='';
		popuphtml+='<div class="message-box animated fadeIn" id="alertPopup">';
		popuphtml+='<div class="nav col-md-6 nav-ul">';
		popuphtml+='<ul class="nav popup-ul bg-ul">';
		popuphtml+='<li>'+popupHtml+'</li>';
		popuphtml+='<li class="btn-li">';
		popuphtml+='<button type="button" class="btn btn-success active mbsure">确认</button>';
		popuphtml+='</li></ul></div></div>';
		$("body").append(popuphtml);
		$("#alertPopup").addClass("open");
		$("body").delegate(".mbsure","click",function(){
			$("#alertPopup").remove();
			$("#alertPopup").removeClass("open");
			if( typeof callback === 'function' ){  
				callback();
			}
		});
}
//回复弹框
function applyPopup(){
	var applyhtml='';
		applyhtml+='<div class="message-box animated fadeIn" id="applyPopup">';
		applyhtml+='<div class="nav col-md-6 nav-ul">';
		applyhtml+='<ul class="nav popup-ul bg-ul">';
		applyhtml+='<li class="diffLi"><input type="hidden" id="lmId"/></li>';
		applyhtml+='<li class="diffLi"><input type="hidden" id="sendUserId"/></li>';
		applyhtml+='<li class="diffLi"><input type="hidden" id="topicId"/></li>';
		applyhtml+='<li class="diffLi commonLi"><textarea name="lmContent" id="lmContentPopup" rows="4" cols="30"></textarea></li>';
		applyhtml+='<li class="btn-li diffLi bLi">';
		applyhtml+='<button type="button" class="btn btn-success active" id="sure2">确认</button>';
		applyhtml+='<button type="button" class="btn btn-default active" id="cancel2">取消</button>';
		applyhtml+='</li></ul></div></div>';
		$("body").append(applyhtml);
		$("#applyPopup").addClass("open");
		$("body").delegate("#sure2","click",function(){
			$("#applyPopup").remove();
			$("#applyPopup").removeClass("open");
			if( typeof callback === 'function' ){  
				callback();
			}
		});
		$("body").delegate("#cancel2","click",function(){
			$("#applyPopup").removeClass("open");
		});
}


$(function(){
	$(".table").addClass("table-hover");
	$(".dataTables_filter").hide();
	var td3 = $(".treegrid-control").parent().find("td");
})
$(".td-left").css({"width":"3%"});
$(".td-left").parent().css({"text-align":"left"});
$("table[role='grid']").addClass("sd");
$(".table").css("margin-bottom","5px");

//菜单权限列表
function wait(){
	$("#searchModuleTree").find("ul:first").find("li:first").addClass("oLi");
    $(".oLi").siblings().addClass("oLi");
    $(".oLi").find("ul:first").addClass("oUl");
    /*$(".oUl").find("li ul").addClass("sec");*/
    $(".oUl").find("li input:first").addClass("liBox");
    $(".liBox").siblings().find("input:first").addClass("liBox");
    $(".oUl").find("li:first").addClass("secP");
    $(".secP").siblings().addClass("secP");
    $(".secP").find("ul:first").find("input[menus=0]").addClass("oInp");
    $(".oInp").parent().parent().parent().addClass("sec");
    $(".sec").find("ul").removeClass("sec");
}
//日期转换
function Format(now,mask)
{
    var d = now;
    var zeroize = function (value, length)
    {
        if (!length) length = 2;
        value = String(value);
        for (var i = 0, zeros = ''; i < (length - value.length); i++)
        {
            zeros += '0';
        }
        return zeros + value;
    };
 
    return mask.replace(/"[^"]*"|'[^']*'|\b(?:d{1,4}|m{1,4}|yy(?:yy)?|([hHMstT])\1?|[lLZ])\b/g, function ($0)
    {
        switch ($0)
        {
            case 'd': return d.getDate();
            case 'dd': return zeroize(d.getDate());
            case 'ddd': return ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'][d.getDay()];
            case 'dddd': return ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'][d.getDay()];
            case 'M': return d.getMonth() + 1;
            case 'MM': return zeroize(d.getMonth() + 1);
            case 'MMM': return ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'][d.getMonth()];
            case 'MMMM': return ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'][d.getMonth()];
            case 'yy': return String(d.getFullYear()).substr(2);
            case 'yyyy': return d.getFullYear();
            case 'h': return d.getHours() % 12 || 12;
            case 'hh': return zeroize(d.getHours() % 12 || 12);
            case 'H': return d.getHours();
            case 'HH': return zeroize(d.getHours());
            case 'm': return d.getMinutes();
            case 'mm': return zeroize(d.getMinutes());
            case 's': return d.getSeconds();
            case 'ss': return zeroize(d.getSeconds());
            case 'l': return zeroize(d.getMilliseconds(), 3);
            case 'L': var m = d.getMilliseconds();
                if (m > 99) m = Math.round(m / 10);
                return zeroize(m);
            case 'tt': return d.getHours() < 12 ? 'am' : 'pm';
            case 'TT': return d.getHours() < 12 ? 'AM' : 'PM';
            case 'Z': return d.toUTCString().match(/[A-Z]+$/);
            // Return quoted strings with the surrounding quotes removed
            default: return $0.substr(1, $0.length - 2);
        }
    });
};

function getAdvWithChannelId(){
	var chk_value =[]; 
	$('input[name="pcCheckboxs"]:checked').each(function(){ 
	chk_value.push($(this).val()); 
	});
	
var str = chk_value.join(",")
    
	$("#topicAdvertisement").empty();
	$("#topicAdvertisement").append("<option value='"+""+"'>"+"没有选中任何项"+"</option>");
	   $.ajax({
            type:"get",
            contentType:"application/json;charset=utf-8",
            url:"/forumTopic/getAdvertisement?channelId="+str,
            success:function(ret){
            	//console.log(ret.result);

	    		$.each(ret.result, function(index,item){ 
	    	        	$("#topicAdvertisement").append("<option value='"+item.id+"'>"+item.active_title+"</option>");
	    	    }); 			
            },
                 error : function(XMLHttpRequest, textStatus, errorThrown) {
                     alert(errorThrown);
             },
                 async:false  //false表示同步
                 });
	   $('#topicAdvertisement').selectpicker('refresh');
}


function channleGetProductList(value) {
	$("#merchantProductId").empty();
	$("#merchantProductId").append("<option value='"+""+"'>"+"没有选中任何项"+"</option>");
	 $.ajax({
         type:"get",
         contentType:"application/json;charset=utf-8",
         url:"/pushlistChannelMonth/getproduct?channelId="+value,
         success:function(ret){
         	//console.log(ret.result);

	    		$.each(ret.result, function(index,item){ 
	    	        	$("#merchantProductId").append("<option value='"+item.productId+"'>"+item.productName+"</option>");
	    	    }); 			
         },
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
            },
                async:false  //false表示同步
                 });
	   $('#merchantProductId').selectpicker('refresh');
}

function shrink(colArr){
    /*<![CDATA[*/
    var tableId = document.getElementById("bigDataList"); 
    var arr = colArr;
    var flag = 0;
    var cntentHide = "<span style='color:#428bca;'>...</span>";
	var cntentShow = "<span style='color:#428bca;margin-left:10px;'>收起</span>";
    for(var i=1;i<tableId.rows.length;i++){ 
	    for(var j=0;j<arr.length;j++){
	    	var arrtd = arr[j];
	    	tableId.rows[i].cells[arrtd].setAttribute('class','tdContent');
	    }
    } 
    $(".tdContent").css({"cursor":"pointer"});
    $(".tdContent").each(function(i){
    	var that = $(this).html();
    	if(that.length > 10){
			var contentSub = $(this).html().substring(0,10);
			$(this).html(contentSub+cntentHide);
				$(this).click(function(){
					if(flag == 0){
						$(this).html(that+cntentShow);
						flag = 1;
					}else{
						$(this).html(contentSub+cntentHide);
						flag = 0;
					}
				})
    	}
	})
    /*]]>*/
}