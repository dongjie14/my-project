function crmUpload(buttonId, showHtmlId, simUploadLimit, picName) {
    var r = parseInt(Math.random() * 999999999999999);
    var loadPath = "";
    var imgPath = "";
    $('#' + buttonId).uploadify({
        'uploader': 'uploadify/scripts/uploadify.swf',
        'script': 'fileUpload.action',   //指定服务端处理类的入口
        'folder': 'upload/image',
        'cancelImg': '/uploadify/chosePic.png',
        'fileDataName': 'fileInput', //和input的name属性值保持一致就好，Struts2就能处理了   
        'queueID': 'fileQueue',
        'auto': true,//是否选取文件后自动上传   
        'multi': true,//是否支持多文件上传
        'simUploadLimit': simUploadLimit,//每次最大上传文件数   
        'buttonText': '浏览图片',//按钮上的文字   
        'heigth': 16,
        'width': 50,
        'fileDesc': '.jpg文件或.gif文件或.png文件',//上传文件类型说明
        'fileExt': '*.jpg;*.gif;*.png',
        'wmode': 'transparent',
        'buttonImg': 'images/chosePic.png',
        'displayData': 'percentage',//有speed和percentage两种，一个显示速度，一个显示完成百分比    
        'onComplete': function (event, queueID, fileObj, response, data) {
            //response：action中的返回值out.print()
            //fileObj.filePath:图片保存的相对路径及图片名
            response = response.replace('\n', "");
            response = response.replace('\r', "");
            $("#" + showHtmlId).css('display', 'block');
            var img = "<img src='upload/image/" + response + "' width='200' height='100'/><br/><br/>";
            var innetHtml = $("#" + showHtmlId).html();
            var aHtml = "&nbsp;&nbsp;<a href='javascript:void(0)'  onclick=\"delUploadPic('" + picName + "',this,'" + response + "')\" ><img src='uploadify/cancel.png'/></a><br/>"
            var picName1 = $("#" + picName).val();
            picName1 = picName1 + "#######" + "upload/image/" + response;
            var html = "<div>" + aHtml + img + "</div>" + innetHtml;
            $("#" + picName).val(picName1);
            $("#" + showHtmlId).html(html);
            alert("文件上传成功!");
        },
        'onSelect': function () {
            alert("文件上传中，请等待……");
        }
    });

}