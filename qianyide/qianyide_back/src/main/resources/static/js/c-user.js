// JavaScript Document
$(function () {

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

});

function upuser() {
    var userName = $("#userName").val();
    var email = $("#email").val();
    var idCard = $("#idCard").val();
    var mobile = $("#mobile").val();
    var address = $("#address").val();
    if (userName == "" || email == "" || idCard == "" || mobile == "" || address == "") {
        alert("带*号选项都必须填写！");
    } else {
        $("#formup").submit();
    }
}

function uppwd() {
    var pwd1 = $("#pwd1").val();
    var pwd2 = $("#pwd2").val();
    var pwd3 = $("#pwd3").val();
    if (pwd1 == "" || pwd2 == "" || pwd3 == "") {
        alert("带*号内容不能为空");
    } else if (pwd2 != pwd3) {
        alert("两次输入密码不一致");
    } else {
        var param = {
            pwd1: pwd1,
            pwd2: pwd2
        };
        $.ajax({
            type: "POST",
            async: false,
            url: "/member/option!updatePwd.do",
            data: param,
            dataType: "json",
            success: function (data) {
                if (data.SUCC == "SUCC") {
                    alert("修改完成！");
                    location.reload(true);
                } else if (data.SUCC == "PWDERR") {
                    alert("原登录密码不正确！");
                } else {
                    alert("系统忙请稍后再试！");
                }
            }
        });
    }
}