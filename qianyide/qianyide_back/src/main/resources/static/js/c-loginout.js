function loginout() {
    var param = {};
    $.ajax({
        type: "POST",
        async: false,
        url: "/user/option!loginOut.do",
        data: param,
        dataType: "json",
        success: function (data) {
            location.reload(true);
        }
    });
}
function changeImgs() {
    document.getElementById("imgCC1").src = "../img.jsp?now=" + new Date();
}
function openLogin() {
    $("#imgCC1").attr("src", "../img.jsp?now=" + new Date());
    if ($('#J_LoginDialog').length) {
        window.loginDialog = new SAL.Dialog({
            target: $('#J_LoginDialog')
        });
    }
    loginDialog.open();
}
function closeLogin() {
    loginDialog.close();
}

function logLogin() {
    var logName = $("#logName").val().replace(/\s+/g, "");
    var logPwd = $("#logpassword").val().replace(/\s+/g, "");
    var logyzm = $("#logyzm").val().replace(/\s+/g, "");
    if (logName != "" && logPwd != "" && logyzm != "") {
        var param = {
            loginName: logName,
            password: logPwd,
            yzm: logyzm
        };
        $.ajax({
            type: "POST",
            async: false,
            url: "/user/option!logLogin.do",
            data: param,
            dataType: "json",
            success: function (data) {
                //location.reload(true);
                if (data.SUCC == "SUCC") {
                    closeLogin();
                    location.reload(true);
                } else if (data.SUCC == "YZMSUCC") {
                    $("#name_pwd").text("验证码错误！").css("color", "red");
                } else {
                    $("#name_pwd").text("用户名或密码错误！").css("color", "red");
                }
            }
        });
    } else {
        alert("请输入用户名、密码及验证码");
    }
}

function searpro1() {
    var productName = $("#productName1").val().replace(/\s+/g, "");
    if (productName == "") {
        alert("请输入要查询的商品名称");
    } else {
        var prourl = encodeURIComponent(productName);
//		alert(prourl);
        location = "/product/option!gotoProductList.do?productName=" + prourl;
    }
}

function searpro() {
    var productName = $("#productName").val().replace(/\s+/g, "");
    if (productName == "") {
        alert("请输入要查询的商品名称");
    } else {
        var prourl = encodeURIComponent(productName);
//		alert(prourl);
        location = "/product/option!gotoProductList.do?productName=" + prourl;
    }
}