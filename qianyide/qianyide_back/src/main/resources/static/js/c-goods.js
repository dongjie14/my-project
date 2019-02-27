// JavaScript Document


$(function () {

    //团购列表倒计时
    new SAL.GroupOnCountDown({
        target: $('#J_Timer')
    });

    //商品详细tabs
    new SAL.Tabs({
        tab: $('#J_DetailTabs a'),
        cont: $('#J_DetailCont .cont')
    });

    //商品图片zoom
    new SAL.Zoom({
        origin: $("#J_Origin"),
        zoomer: $("#J_Zoomer"),
        viewer: $("#J_Viewer"),
        multiple: 3 //放大倍数
    });

    ~function () {
        var $J_PicTransLi = $('#J_PicTrans li'), $J_PicViews = $('#J_PicViews');
        $J_PicTransLi.mouseover(function () {
            $J_PicTransLi.removeClass('active');
            $J_PicViews.attr('src', $(this).addClass('active').find('img').attr('src'));
        });
    }();

    ~function () {
        if ($('#J_CarDialog').length) {
            //购物车dialog
            var carDialog = new SAL.Dialog({
                target: $('#J_CarDialog')
            });
            //加入购物车
            $('.J_AddCar').click(function () {
                var guige = $("#guigevalue").val();
                var pronum = $("#pronum").val();
                var prodid = $("#prodid").val();
                //alert(pronum+"  "+prodid+"  "+guige);
                if (guige == "") {
                    alert("请选择规格");
                } else {
                    var param = {
                        productId: prodid,
                        proNum: pronum,
                        modelId: guige
                    };
                    $.ajax({
                        type: 'POST',
                        async: false,
                        url: "/cart/option!addCart.do",
                        data: param,
                        dataType: "json",
                        success: function (data) {
                            var strs = new Array();
                            strs = data.SUCC.split(",");
                            if (strs.length == 3) {
                                $("#numsPro").text(strs[1]);
                                $("#priPro").text(strs[2]);
                                carDialog.open();
                            } else {
                                //alert(data.SUCC);
                            }
                        },
                        error: function () {
                            //carDialog.open();
                            alert("系统忙，请稍后再试！");
                        }
                    });
                }
            });

            //继续购买
            $('#J_Continue').click(function () {
                carDialog.close();
            });
        }
    }();

    $('')

    ~function () {

        $('#J_CarDialog, #J_RecommendBlock').each(function () {
            var $pager = '', $slider = $(this).find('.rec-slider ul');
            if ($slider.length > 1) {
                $slider.each(function (i) {
                    $pager += i ? '<li></li>' : '<li class="active"></li>';
                });
                $pager = $($pager).appendTo($(this).find('.rec-pager'))
                new SAL.Slides({
                    $slider: $slider,
                    $pager: $pager,
                    fx: 'horizontal'
                });
            }
        });

    }();


});

function guige(itemId, malPrice, marPrice) {
    $("#specId1").find("span").removeClass("active");
    $("#item" + itemId).hasClass("active") ? $("#item" + itemId).removeClass("active") : $("#item" + itemId).addClass("active");
    $("#guigevalue").val(itemId);
    $("#sumpricesmal").text(malPrice);
    $("#sumpricesmar").text(marPrice);
}

function addNum() {
    var sumPrice = $("#sumprices").text();
    var nums = $("#pronum").val();
    var sum = 1;
    var pattern = /^([0-9])*$/;
    if (!pattern.test(nums)) {
        alert("请输入数字!");
        return;
    }
    sum = parseInt(nums) + 1;
    sump = parseFloat(sumPrice) * sum;
    $("#pronum").val(sum);
    $("#sumprice").text(sump);
}
function minNum() {
    var sumPrice = $("#sumprices").text();
    var nums = $("#pronum").val();
    var sum = 1;
    var pattern = /^([0-9])*$/;
    if (!pattern.test(nums)) {
        alert("请输入数字!");
        return;
    }
    if (parseInt(nums) > 1) {
        sum = parseInt(nums) - 1;
        sump = parseFloat(sumPrice) * sum;
        $("#pronum").val(sum);
        $("#sumprice").text(sump);
    } else {
        sump = parseFloat(sumPrice) * sum;
        $("#pronum").val(sum);
        $("#sumprice").text(sump);
    }
}

function searchAgent(obj) {
    if (obj != "") {
        location = "/agent/option!gotoAgents.do?marketId=" + obj;
    } else {
        location = "/agent/option!gotoAgents.do";
    }
}
function searchAg(obj) {
    if (obj != "") {
        location = "/agent/option!gotoAgents.do?agentId=" + obj;
    } else {
        location = "/agent/option!gotoAgents.do";
    }
}

function optionPrice(price) {
    if (price != "") {
        $("#price1").val(price);
        $("#price2").val("");
        var sortId = $("#sortId").val();
        var brandId = $("#brandId").val();
        var productName = $("#productNamess").val();
        location = "/product/option!gotoProductList.do?sortId=" + sortId + "&brandId=" + brandId + "&productName=" + productName + "&price1=" + price;
    }
}
function optionPrices(price1, price2) {
    if (price1 != "" && price2 != "") {
        $("#price1").val(price1);
        $("#price2").val(price2);
        var sortId = $("#sortId").val();
        var brandId = $("#brandId").val();
        var productName = $("#productNamess").val();
        location = "/product/option!gotoProductList.do?sortId=" + sortId + "&brandId=" + brandId + "&productName=" + productName + "&price1=" + price1 + "&price2=" + price2;
    }
}

function xunwen(obj) {
    $("#xwdid").text(obj);
    $("#xwagentName").val(obj);
    var loginwidth = $(document).width();
    var loginheight = $(document).height();
    $("#mask").css({"width": loginwidth + "px", "height": loginheight + "px"});
    $("#mask").fadeIn(300);
    $("#forgetpassword").fadeIn(400);
    $("#mask, #forgetpassword .close").click(function () {
        $("#mask").fadeOut(300);
        $("#forgetpassword").fadeOut(300);
    });
}
function savexw() {
    var agentname = $("#xwagentName").val();
    var title = $("#xwtitle").val();
    var detail = $("#xwdetail").val();
    var username = $("#xwuserName").val();
    var mobile = $("#xwmobile").val();
    var address = $("#xwaddress").val();
    if (agentname != "" && title != "" && detail != "" && username != "" && mobile != "" && address != "") {
        $("#formxw").submit();
    } else {
        alert("带*号为必填项，请完善资料方便我们联系您！");
    }
}