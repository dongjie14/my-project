// JavaScript Document

$(function () {

    if (window.loginDialog) {
//		loginDialog.open();
    }

    ~function () {
        if ($('#J_ClassifyTabs').length) {
            new SAL.Slides({
                $slider: $('#J_ClassifyTabs').find('.tab-cont .cont'),
                $pager: $('#J_ClassifyTabs').find('.tab-item li'),
                $prev: $('#J_ClassifyTabs').find('.prev'),
                $next: $('#J_ClassifyTabs').find('.next'),
                pagerEvent: 'click',
                speed: 800,
                cycleSlide: false,
                fx: 'horizontal' //不需要动画则为none
            });
        }
    }();


    //财付通更多支付弹窗
    ~function () {
        if ($('#J_PaySelectDialog').length) {
            window.paymentDialog = new SAL.Dialog({
                target: $('#J_PaySelectDialog')
            });
            $('#J_PayOther').click(function () {
                paymentDialog.open();
            });
            $('#J_AreaSelector').click(function () {
                $('#J_AreaSelectorBox').show();
            });
            $('#J_AreaSelectorBox .close').click(function () {
                $('#J_AreaSelectorBox').hide();
                return false;
            });
            $('#J_AreaSelectorBox dd a').click(function () {
                $('#J_AreaSelector i').html($(this).text())
                $('#J_AreaSelectorBox').hide();
                return false;
            });
        }
    }();

    //支付方式切换
    ~function () {
        var $cont = $('.J_PaySwitchCont .cont'), $li = $('#J_PaySwitch li');
        $li.click(function () {
            var index = $(this).index();
            $li.removeClass('active').eq(index).addClass('active');
            $cont.each(function () {
                if ($(this).index() == index) {
                    $(this).addClass('active');
                } else {
                    $(this).removeClass('active');
                }
            });
        }).eq(0).click();
        ;
    }();

    //支付方式选择
    ~function () {
        var $label = $('.J_PaySelect label[for]');
        $label.click(function () {
            $label.removeClass('active');
            $(this).addClass('active').find('input').attr('checked', true);
        }).find(':checked').click();
    }();

    //确认支付
    ~function () {
        if ($('#J_ConfirmDialog').length) {
            confirmDialog = new SAL.Dialog({target: $('#J_ConfirmDialog')});

//			$('button.J_CheckPay').click(function(){
//				//dosomething
//				if(window.paymentDialog){
//					window.paymentDialog.close();
//				}
//				confirmDialog.open();
//			});
        }
    }();

});
//减数量
function reCartNum(obj) {
    var cartNum = $("#cartNum" + obj).val();
    var pcart = $("#pcart" + obj).text();
    var zjg = $("#zongjg").text();
    var pattern = /^([0-9])*$/;
    if (!pattern.test(cartNum)) {
        alert("请输入数字!");
        return;
    }

    cartNum = parseInt(cartNum);
    if (cartNum == 1) {
        alert("数量不能低于1");
    } else if (cartNum < 1) {
        alert("数量不能低于1");
    } else {
        cartNum = cartNum - 1;
        $("#cartNum" + obj).val(cartNum);
        pcart = parseFloat(pcart);
        $("#zonghe" + obj).text(pcart * cartNum);
        zjg = parseFloat(zjg);
        $("#zongjg").text(zjg - pcart);
        var param = {
            cartId: obj,
            proNum: cartNum
        };
        $.ajax({
            type: "POST",
            async: false,
            url: "/cart/option!changReCart.do",
            data: param,
            dataType: "json",
            success: function (data) {
            }
        });
    }
}
//加数量
function addCartNum(obj) {
    var cartNum = $("#cartNum" + obj).val();
    var pcart = $("#pcart" + obj).text();
    var zjg = $("#zongjg").text();
    var pattern = /^([0-9])*$/;
    if (!pattern.test(cartNum)) {
        alert("请输入数字!");
        return;
    }
    cartNum = parseInt(cartNum);
    cartNum = cartNum + 1;
    $("#cartNum" + obj).val(cartNum);
    pcart = parseFloat(pcart);
    $("#zonghe" + obj).text(pcart * cartNum);
    zjg = parseFloat(zjg);
    $("#zongjg").text(zjg + pcart);

    var param = {
        cartId: obj,
        proNum: cartNum
    };
    $.ajax({
        type: "POST",
        async: false,
        url: "/cart/option!changReCart.do",
        data: param,
        dataType: "json",
        success: function (data) {
        }
    });
}

function changeNum(obj) {
    var cartNum = $("#cartNum" + obj).val();
    var pcart = $("#pcart" + obj).text();
    var zjg = $("#zongjg").text();
    var pattern = /^([0-9])*$/;
    if (!pattern.test(cartNum)) {
        alert("请输入数字!");
        return;
    }
    cartNum = parseInt(cartNum);
    pcart = parseFloat(pcart);
    $("#zonghe" + obj).text(pcart * cartNum);
    var param = {
        cartId: obj,
        proNum: cartNum
    };
    $.ajax({
        type: "POST",
        async: false,
        url: "/cart/option!changReCart.do",
        data: param,
        dataType: "json",
        success: function (data) {
        }
    });
}

function delcart(obj) {
    var param = {
        cartId: obj
    };
    $.ajax({
        type: "POST",
        async: false,
        url: "/cart/option!delCart.do",
        data: param,
        dataType: "json",
        success: function (data) {
            location.reload(true);
        }
    });
}

function jiesuan() {
    var param = {};
    $.ajax({
        type: "POST",
        async: false,
        url: "/cart/option!settleCart.do",
        data: param,
        dataType: "json",
        success: function (data) {
            if (data.SUCC == "LOGIN") {
                $("#imgCC1").attr("src", "../img.jsp?now=" + new Date());
                if ($('#J_LoginDialog').length) {
                    window.loginDialog = new SAL.Dialog({
                        target: $('#J_LoginDialog')
                    });
                }
                loginDialog.open();
            } else if (data.SUCC == "SUCC") {
                location = "/cart/option!gotoFillin.do";
            } else {
                alert("系统忙！请稍后再试");
            }
        }
    });
}

function addUserInfo() {
    var cityId = $("#cityId").val();
    var uinfoadress = $("#uinfoadress").val();
    var uinfoname = $("#uinfoname").val();
    var uinfomobile = $("#uinfomobile").val();
    var uinfotelephone = $("#uinfotelephone").val();
    var uinfotype = $("#uinfotype").val();
    var uinfomail = $("#uinfomail").val();
    if (cityId == "") {
        alert("请选择地区");
    } else if (uinfoadress == "") {
        alert("请填写详细地址");
    } else if (uinfoname == "") {
        alert("请填写收货人");
    } else if (uinfomobile == "" && uinfotelephone == "") {
        alert("请填写联系电话");
    } else if (uinfotype == "") {
        alert("请选择送货要求");
    } else {
        $("#forminfo").submit();
    }
}

function addUserInfo1() {
    var cityId = $("#cityId1").val();
    var uinfoadress = $("#uinfoadress1").val();
    var uinfoname = $("#uinfoname1").val();
    var uinfomobile = $("#uinfomobile1").val();
    var uinfotelephone = $("#uinfotelephone1").val();
    var uinfotype = $("#uinfotype1").val();
    var uinfomail = $("#uinfomail1").val();
    if (cityId == "") {
        alert("请选择地区");
    } else if (uinfoadress == "") {
        alert("请填写详细地址");
    } else if (uinfoname == "") {
        alert("请填写收货人");
    } else if (uinfomobile == "" && uinfotelephone == "") {
        alert("请填写联系电话");
    } else if (uinfotype == "") {
        alert("请选择送货要求");
    } else {
        $("#formadd").submit();
    }
}

function omoren(obj) {
    if (obj != "") {
        var param = {
            infoId: obj
        };
        $.ajax({
            type: "POST",
            async: false,
            url: "/cart/option!settMoren.do",
            data: param,
            dataType: "json",
            success: function (data) {
                if (data.SUCC == "SUCC") {
                    $("#morenid" + obj).text("默认地址");
                    location.reload(true);
                } else {
                    alert("系统忙请稍后再试！");
                }
            }
        });
    } else {
        alert("系统忙请稍后再试！");
    }
}

function addAddr() {
    $("#addaddr").css("display", "block");
}

function delinfo(obj) {
    if (obj != "") {
        var param = {
            infoId: obj
        };
        $.ajax({
            type: "POST",
            async: false,
            url: "/cart/option!delInfo.do",
            data: param,
            dataType: "json",
            success: function (data) {
                if (data.SUCC == "SUCC") {
                    location.reload(true);
                } else {
                    alert("系统忙，请稍后再试！");
                }
            }
        });
    } else {
        alert("系统忙，请稍后再试！");
    }
}

function updateInfo(obj) {
    //city  address  username  mobile  telephone  deliRequest  email
    if (obj != "") {
        var cityid = $("#cityId" + obj).val();
        var city = $("#city" + obj).val();
        var address = $("#address" + obj).val();
        var username = $("#username" + obj).val();
        var mobile = $("#mobile" + obj).val();
        var telephone = $("#telephone" + obj).val();
        var deliRequest = $("#deliRequest" + obj).val();
        var email = $("#email" + obj).val();
        var infotype = $("#infotype" + obj).val();
        $("#addupd").css("display", "block");
        $("#uinfoid").val(obj);
        $("#cityId2").val(cityid);
        $("#uinfoadress2").val(address);
        $("#uinfoname2").val(username);
        $("#uinfomobile2").val(mobile);
        $("#uinfotelephone2").val(telephone);
        $("#uinfotype2").val(deliRequest);
        $("#uinfomail2").val(email);
        $("#uinfotype2").val(infotype);

    } else {
        alert("系统忙，请稍后再试！");
    }
}

function addUserInfo2() {
    var cityId = $("#cityId2").val();
    var uinfoadress = $("#uinfoadress2").val();
    var uinfoname = $("#uinfoname2").val();
    var uinfomobile = $("#uinfomobile2").val();
    var uinfotelephone = $("#uinfotelephone2").val();
    var uinfotype = $("#uinfotype2").val();
    var uinfomail = $("#uinfomail2").val();
    if (cityId == "") {
        alert("请选择地区");
    } else if (uinfoadress == "") {
        alert("请填写详细地址");
    } else if (uinfoname == "") {
        alert("请填写收货人");
    } else if (uinfomobile == "" && uinfotelephone == "") {
        alert("请填写联系电话");
    } else if (uinfotype == "") {
        alert("请选择送货要求");
    } else {
        $("#formupd").submit();
    }
}

function compName() {
    $("#compname").css("display", "block");
    $("#gsgr").val("comp");
}

function uncompName() {
    $("#compname").css("display", "none");
    $("#gsgr").val("pers");
}

function gotozhifu() {
    var che = document.getElementsByName("Address");
    var address = "";
    for (var x = 0; x < che.length; x++) {
        if (che[x].checked == true) {
            address = che[x].value;
        }
    }
    var gsgr = $("#gsgr").val();
    var dwmc = $("#dwmc").val().replace(/\s+/g, "");
    var fpnr = $("#fpnr").val().replace(/\s+/g, "");
    var orderremark = $("#orderremark").val().replace(/\s+/g, "");
//	dwmc=encodeURIComponent(dwmc);
//	fpnr=encodeURIComponent(fpnr);
//	orderremark=encodeURIComponent(orderremark);
    if (gsgr == "comp") {
        if (dwmc == "") {
            alert("请输入单位名称");
        } else {
            $("#payinfoId").val(address);
            $("#paycompName").val(dwmc);
            $("#payinvoiceType").val("Y");
            $("#payinvoiceMsg").val(fpnr);
            $("#payorderRemark").val(orderremark);
            $("#payform").submit();
            //location = "/order/option!saveOrder.do?infoId="+address+"&compName="+dwmc+"&invoiceType=Y&invoiceMsg="+fpnr+"&orderRemark="+orderremark;
        }
    } else {
        $("#payinfoId").val(address);
        $("#paycompName").val(dwmc);
        $("#payinvoiceType").val("N");
        $("#payinvoiceMsg").val(fpnr);
        $("#payorderRemark").val(orderremark);
        $("#payform").submit();
//		location = "/order/option!saveOrder.do?infoId="+address+"&compName="+dwmc+"&invoiceType=N&invoiceMsg="+fpnr+"&orderRemark="+orderremark;
    }
}

function swichpays() {
    $("#payswich").css("display", "block");
}
function swichpay() {
    $("#payswich").css("display", "none");
}
function ordersucc() {
    var orderNum = $("#ordernums").val();
    var totalPrice = $("#totalprices").val();
    location = "/order/option!gotoOrderSucc.do?orderNum=" + orderNum + "&totalPrice=" + totalPrice;
}