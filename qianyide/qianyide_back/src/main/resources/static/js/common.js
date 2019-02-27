// JavaScript Document
$(document).ready(function() {
	// 搜索页让input框直接获取焦点
	$('#search').trigger("click").focus();
	//找回密码页 密码显示或隐藏
        //改进版
         var flag=0;      
        $('.see-password').click(function(event) {
            if ($('#mm1').val()=='' && $('#mm2').val()=='') {
                 // alert('请输入密码');
             }else{
                mm();
             }
        });
       function mm () {
            var temp1= $('#mm1').val();
            var temp2= $('#mm2').val(); 
            if (flag==0) {
                $('.see-password').addClass('see');
                $('#ming1').html('<input type="text" id="mm1">');
                $('#ming2').html('<input type="text" id="mm2">');

                flag=1;
            }else{
                $('.see-password').removeClass('see');
                $('#ming1').html('<input type="password" id="mm1">');
                $('#ming2').html('<input type="password" id="mm2">');
                flag=0;
            }
               $('#mm1').val(temp1);
                $('#mm2').val(temp2); 
            }
     //当时给后台的版本      
    // var flag=0;
    //     $('.see-password').click(function(event) {
    //         var temp1= $('#mm1').val();
    //         var temp2= $('#mm2').val(); 
    //         if (flag==0) {
    //             $(this).addClass('see');
    //             $('#ming1').html('<input type="text" id="mm1">');
    //             $('#ming2').html('<input type="text" id="mm2">');

    //             flag=1;
    //         }else{
    //             $(this).removeClass('see');
    //             $('#ming1').html('<input type="password" id="mm1">');
    //             $('#ming2').html('<input type="password" id="mm2">');
    //             flag=0;
    //         }
    //            $('#mm1').val(temp1);
    //             $('#mm2').val(temp2); 
    //         }); 
    //  }

		//获取验证码-倒计时 
        var wait=60;
        var timer=null;     
         $('#sendcode').click(function(event) {
            clearTimeout(timer);
            $('#sendcode').attr("disabled",false);
            time();
         });
          function time(){
            if (wait==0) {
            	$('#sendcode').removeClass('hqz');
                $('#sendcode').val('获取验证码');
                wait=60;
                }else{
                	$('#sendcode').addClass('hqz');
                    $('#sendcode').attr("disabled",true);
                    $('#sendcode').val(wait+'s后重试');
                    wait--;
                    timer=setTimeout(function(){time();}, 1000);
                }
            }
    // 信用卡详情 tab切换
    $('.itembox .item').eq(0).css('display', 'block');

     $('.tab li').click(function(event) {
        $(this).addClass('now').siblings().removeClass('now');
        var s=$(this).index();
        $('.itembox .item').eq(s).show().siblings('.item').hide();
    
     });

    //白户借款-初始化
    for (var i = 1; i <= 100; i++) {
        var C=3*i-1;
        $('.jk-pt').children('dd').eq(C).css('margin-right', 0);      
    };

    // 单项选择效果
    $('.short-input input').click(function(event) {
        $(this).next('.radio-xz').show();
        $('.cover').show();
    });
    $('.radio-xz li').click(function(event) {
        $(this).addClass('selected').siblings('li').removeClass('selected');
        var con = $(this).html();
        $(this).parent('ol').prev().val(con);
        $(this).parent('ol').delay(1000).hide();
        $('.cover').hide();
    });
	// 房贷计算tab
    $('.tab-con .tab-content').eq(0).css('display', 'block'); 
    $('.tab-list li').click(function(event) {
    $(this).addClass('active').siblings().removeClass('active');
    var s=$(this).index();
    $('.tab-con .tab-content').eq(s).show().siblings('.tab-content').hide();
        }); 
    //房贷计算每个dl里面第一个dd里面的a添加一个上边框
    var obj=0;
    $('.user-data dl').each(function() {
        obj = $(this).find("dd:last");
        obj.children('a').css('border', 'none');
    });
    var ob=0;
    $('.count dl').each(function() {
        ob = $(this).find("dd:first");
        ob.children('a').css('border-top', '1px solid #e8e8e8');
    });
    //信用卡投标tab切换 start-------------------
    $('.mall-tab li').click(function(event) {
        $(this).toggleClass('xz-extend').siblings().removeClass('xz-extend');
        var s=$(this).index();
        $('.item').eq(s).slideToggle().siblings('.item').hide();
        $('.item').eq(s).children('.mask').fadeToggle().parents('.item').siblings().children('.mask').hide();
    });
    $('.mask').click(function(event) {
       $('.item').slideUp();
       $('.mall-tab li').removeClass('xz-extend');
    });
    // 选择功能
    //功能选择框初始化
    function backnormal (box) {
         for (var i = 1; i <= 100; i++) {
            var B=3*i-1;
            $(box).find('li').eq(B).css('margin-right', 0);      
        };
     } 
     backnormal('.item-01');
     backnormal('.item-03');
     backnormal('.item-04');
     backnormal('.item-05');
    $('.item-01 li').click(function(event) {
        $(this).toggleClass('now');
    });
        // 点击完成的效果
        $('.submit-btn').click(function(event) {
            $(this).parents('.item').slideUp();
            $('.mask').hide();
            $('.xy-tab li:eq(0)').removeClass('xz-extend');
        });
        //点击重置效果
          $('.reset-btn').click(function(event) {
              $('.item-01 li').removeClass('now');
          });
    //选择银行
    $('.item-02 li').click(function(event) {
        $(this).addClass('dq-now').siblings().removeClass('dq-now');
        $(this).parents('.item').slideUp();
        $('.mask').hide();
        var Con=$(this).children('span').html();
        $('.xy-tab li:eq(1) i').html(Con);
        $('.xy-tab li:eq(1) i').css('color', '#fb4747');
        $('.xy-tab li:eq(1)').removeClass('xz-extend')
    });
    // 等级选择
    $('.item-03 li').click(function(event) {
        $(this).addClass('now').siblings().removeClass('now');
        $(this).parents('.item').slideUp();
        $('.mask').hide();
        var Con=$(this).html();
        $('.xy-tab li:eq(2) i').html(Con);
        $('.xy-tab li:eq(2) i').css('color', '#fb4747');
        $('.xy-tab li:eq(2)').removeClass('xz-extend')
    });

    // 贷款顶部导航
    // 贷款金额
    $('.item-04 li').click(function(event) {
        $(this).addClass('now').siblings().removeClass('now');
        $(this).parents('.item').slideUp();
        $('.mask').hide();
        var Con=$(this).html();
        $('.dk-tab li:eq(0) i').html(Con);
        $('.dk-tab li:eq(0) i').css('color', '#fb4747');
        $('.dk-tab li:eq(0)').removeClass('xz-extend')
    });
    // 贷款类型
    $('.item-05 li').click(function(event) {
            $(this).toggleClass('now');
        });
            // 点击完成的效果
            $('.submit-btn').click(function(event) {
                $(this).parents('.item').slideUp();
                $('.mask').hide();
                $('.dk-tab li:eq(1)').removeClass('xz-extend');
            });
            //点击重置效果
              $('.reset-btn').click(function(event) {
                  $('.item-05 li').removeClass('now');
              });
    // 车贷计算
    $('.count .yq-cost dd a').click(function(event) {
        $(this).toggleClass('current');
        $(this).next().slideToggle();
    });












});