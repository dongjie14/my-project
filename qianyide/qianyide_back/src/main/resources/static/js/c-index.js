// JavaScript Document

$(function () {
    ~function superSlider() {
        var $slider = $('#J_SuperSlider ul li'),
            $pager = $('#J_SuperSlider ol')
        html = [];
        if ($slider.length > 1) {
            for (var i = 0; i < $slider.length; i++) {
                html.push(i == 0 ? '<li class="active"></li>' : '<li></li>');
            }
            $pager.html(html.join(''))
            new SAL.Slides({
                $slider: $slider,
                $pager: $pager.find('li'),
                speed: 500,
                delay: 5000,
                fx: 'horizontal'
            });
        }
    }();

    new SAL.Slides({
        $slider: $('#J_ClassifyTabs').find('.tab-cont .cont'),
        $pager: $('#J_ClassifyTabs').find('.tab-item li'),
        pagerEvent: 'click',
        cycleSlide: false,
        speed: 800,
        fx: 'horizontal' //不需要动画则为none
    });

});