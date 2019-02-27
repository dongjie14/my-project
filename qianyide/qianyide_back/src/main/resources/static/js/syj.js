/**
 * Created by jzhang on 2017/5/26 0026.
 */
/*<![CDATA[*/
SYJ = {
    // alert:function (obj) {
    //     showLoader(obj);
    // },
    /**
     * 判断非空
     * @param obj
     * @returns {boolean}
     */
    isEmpty: function (obj) {
        if (obj == undefined || obj == null || new String(obj).trim() == '') {
            return true;
        } else {
            return false;
        }
    },
    /**
     * 判断非空
     * @param obj
     * @returns {boolean}
     */
    isNotEmpty: function (obj) {
        return isEmpty(obj) ? false : true;
    },
    /**
     * 忽略大小写判断字符串是否相同
     * @param str1
     * @param str2
     * @returns {Boolean}
     */
    isEqualsIgnorecase:function(str1,str2){
        if(str1.toUpperCase() == str2.toUpperCase()){
            return true;
        }else{
            return false;
        }
    },
    /**
     * 判断是否是数字
     * @param value
     * @returns {Boolean}
     */
    isNum:function (value){
        if( value != null && value.length>0 && isNaN(value) == false){
            return true;
        }else{
            return false;
        }
    },
    /**
     * 判断是否是中文
     * @param str
     * @returns {Boolean}
     */
    isChine:function(str){
        var reg = /^([u4E00-u9FA5]|[uFE30-uFFA0])*$/;
        if(reg.test(str)){
            return false;
        }
        return true;
    },
    /**
     * 发送短信
     * @param tel
     * @returns {boolean}
     */
    sendSms: function (tel) {
        if (!SYJ.formCheckTellphone(tel)) {
            return false;
        }
        var param = {
            userPhone: tel,
            isExist: 1
        };
        $.ajax({
            type: "POST",
            async: false,
            url: "web/sendSmsCode",
            data: param,
            dataType: "json",
            success: function (ret) {
                console.log(ret);
                if (ret.code == '0') {
                    return true;
                } else {
                    return false;
                }
            }
        });
    },
    /**
     * 验证手机号
     * @param value
     * @returns {boolean}
     */
    formCheckTellphone: function (value) {
        return /^((13[0-9])|(15[^4])|(18[^4])|(17[0-8])|(147))\d{8}$/i.test(value);
    },
    <!-- 验证码倒计时效果 -->
    /**
     *
     * @param o document 获取的原生对象
     * @param wait 等待时间
     */
    time: function (o, wait) {
        if (wait == 0) {
            o.removeAttribute("disabled");
            o.value = "获取验证码";
            wait = 60;
            o.setAttribute('class', '');
        } else {
            o.setAttribute('class', 'wait');
            o.setAttribute("disabled", true);
            o.value = wait + "s后重试";
            wait--;
            setTimeout(function () {
                    SYJ.time(o, wait)
                },
                1000)
        }
    },
    /**
     * 提交表单数据
     * 需引用jquery-form.js
     * @param formName formID
     * @param url
     * @param dataType
     * @param callback 回调函数
     */
    loadPageWithForm: function (formName, url, dataType, callback) {
        $("#" + formName).ajaxSubmit({
            type: "POST",
            url: url,
            dataType: dataType,
            complete: function (XMLHttpRequest, textStatus) {
            },
            success: function (data) {
                callback(data);
            }
        });
    },
    /**
     * 带参下载文件
     * @param url
     * @param data
     * @param method
     * @constructor
     */
    DownLoadFile: function (url, data) {
        var method = arguments[2] == undefined ? 'post' : arguments[2];
        var options = {
            url: url,
            data: data,
            method: method
        }
        var config = $.extend(true, {method: 'post'}, options);
        var $iframe = $('<iframe id="down-file-iframe" />');
        var $form = $('<form target="down-file-iframe" method="' + config.method + '" />');
        $form.attr('action', config.url);
        for (var key in config.data) {
            $form.append('<input type="hidden" name="' + key + '" value="' + config.data[key] + '" />');
        }
        $iframe.append($form);
        $(document.body).append($iframe);
        $form[0].submit();
        $iframe.remove();
    }
}

/*]]>*/