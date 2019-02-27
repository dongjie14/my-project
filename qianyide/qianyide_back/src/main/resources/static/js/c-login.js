// JavaScript Document


$(function () {
    //密码强度提示
    ~function () {
        var $strong = $('.strength .item'), verify, getStrength;
        if (!$strong.length) {
            return;
        }
        verify = function () {
            var strength = getStrength($(this).val());
            if (strength == 1) {
                $strong.removeClass('active').eq(0).addClass('active');
            } else if (strength == 2) {
                $strong.addClass('active').eq(2).removeClass('active');
            } else if (strength > 2) {
                $strong.addClass('active');
            } else {
                $strong.removeClass('active');
            }
        };
        getStrength = function (val) {
            var ret = 0;
            ret = /\d/.test(val) ? ret + 1 : ret;
            ret = /[a-zA-z]/.test(val) ? ret + 1 : ret;
            ret = /[^a-zA-z\d]/.test(val) ? ret + 1 : ret;
            ret = val.length < 6 ? 0 : ret;
            return ret;
        };
        $strong.closest('dd').find('input:password').on({
            'click': verify,
            'keyup': verify,
            'change': verify
        });
    }();


    $('.J_InpText input:text,.J_InpText input:password').on({
        focus: function () {
            $(this).closest('dl').addClass('active-cont');
        },
        blur: function () {
            $(this).closest('dl').removeClass('active-cont');
        }
    });

});
function changeImg() {
    document.getElementById("image2").src = "../img.jsp?now=" + new Date();
}
function checkName() {
    var loginName = $("#loginName").val().replace(/\s+/g, "");
    if (loginName != "") {
        var param = {
            loginName: loginName
        };
        $.ajax({
            type: "POST",
            async: false,
            url: "/user/option!checkName.do",
            data: param,
            dataType: "json",
            success: function (data) {
                if (data.SUCC == "SUCC") {
                    $("#spanname").text("可以注册！").css("color", "green");
                    //location.reload(true);
                } else if (data.SUCC == "EXSUCC") {
                    $("#spanname").text("用户名已存在！").css("color", "red");
                } else {
                    alert("系统忙，请稍后再试！");
                }
            }
        });
    }
    //else{
    //	$("#spanname").html("请输入用户名");
    //}
}
function checkPwd() {
    var pwd = $("#password").val().replace(/\s+/g, "");
    var repwd = $("#repassword").val().replace(/\s+/g, "");
    if (pwd == "") {
        $("#spanpwd").text("请输入密码！").css("color", "red");
    } else {
        $("#spanpwd").text("");
        if (repwd != "" && pwd == repwd) {
            $("#spanrepwd").text("");
        }
    }

}

function checkRePwd() {
    var pwd = $("#password").val().replace(/\s+/g, "");
    var repwd = $("#repassword").val().replace(/\s+/g, "");
    if (pwd != "" && repwd != "") {
        if (pwd != repwd) {
            $("#spanrepwd").text("两次密码不一致！").css("color", "red");
        } else {
            $("#spanrepwd").text("");
        }
    } else if (repwd == "") {
        $("#spanrepwd").text("请输入密码！").css("color", "red");
    } else if (pwd == "") {
        $("#spanpwd").text("请输入密码！").css("color", "red");
    }
}

function reguser() {
    var loginName = $("#loginName").val().replace(/\s+/g, "");
    var pwd = $("#password").val().replace(/\s+/g, "");
    var repwd = $("#repassword").val().replace(/\s+/g, "");
    var yzm = $("#yzm").val().replace(/\s+/g, "");
    if (loginName != "" && pwd != "" && repwd != "" && yzm != "") {
        $("#formreg").submit();
    } else {
        alert("请输入用户名、密码及验证码");
    }
}

function userlogin() {
    var loginName = $("#loginName").val().replace(/\s+/g, "");
    var pwd = $("#password").val().replace(/\s+/g, "");
    var yzm = $("#yzm").val().replace(/\s+/g, "");
    if (loginName != "" && pwd != "" && yzm != "") {
        $("#formlog").submit();
    } else {
        alert("请输入用户名、密码及验证码");
    }
}