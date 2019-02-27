;(function ($) {

//check namespace
    window.SAL = window.SAL || {};
    $.SAL = $.SAL || {};

    if ($.browser.msie && $.browser.version == "6.0") {
        try {
            document.execCommand('BackgroundImageCache', false, true);
        } catch (e) {
        }
    }
    ;

//Class constructor
    SAL.Class = function () {
        function extendClass(Class, extension, override) {
            if (extension.STATIC) {
                extend(Class, extension.STATIC, override);
                delete extension.STATIC;
            }
            extend(Class.prototype, extension, override);
        }

        function extend(obj, extension, override) {
            var prop;
            if (override === false) {
                for (prop in extension) {
                    (prop in obj) || (obj[prop] = extension[prop]);
                }
            } else {
                for (prop in extension) {
                    obj[prop] = extension[prop];
                }
                extension.toString !== Object.prototype.toString && (obj.toString = extension.toString);
            }
        }

        SAL.extend = extend;
        SAL.extendClass = extendClass;
        return function () {
            var len = arguments.length,
                base = arguments[len - 1],
                SuperClass = len > 1 ? arguments[0] : null,
                hasExtendClass = len > 2,
                Class,
                SuperClassEmpty;
            if (base.constructor === Object) {
                Class = function () {
                };
            } else {
                Class = base.constructor;
                delete base.constructor;
            }
            if (SuperClass) {
                SuperClassEmpty = function () {
                };
                SuperClassEmpty.prototype = SuperClass.prototype;
                Class.prototype = new SuperClassEmpty();
                Class.prototype.constructor = Class;
                Class.SuperClass = SuperClass;
                extendClass(Class, SuperClass, false);
            }
            if (hasExtendClass) {
                for (var i = 1; i < len; i++) {
                    extend(Class, arguments[i].prototype, false);
                }
            }
            extendClass(Class, base, false);
            return Class;
        };
    }();

    /* cookie 工具 */
    SAL.cookie = {
        get: function (key) {
            if (document.cookie && document.cookie != '') {
                var cookies = document.cookie.split(';'), i = 0, c;
                for (; i < cookies.length; i++) {
                    c = cookies[i].replace(/^(\s*)|(\s*)$/, '');
                    if (key + '=' == c.substring(0, key.length + 1)) {
                        return decodeURIComponent(c.substring(key.length + 1));
                    }
                }
            }
            return null;
        },
        set: function (key, value, options) {
            options = options || {};
            var date,
                expires = '',
                path = options.path ? '; path=' + options.path : '',
                domain = options.domain ? '; domain=' + options.domain : '',
                secure = options.secure ? '; secure' : '';
            if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
                if (typeof options.expires == 'number') {
                    date = new Date();
                    date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
                } else if (options.expires.toUTCString) {
                    date = options.expires;
                }
                expires = '; expires=' + date.toUTCString();
            }
            document.cookie = [key, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
        },
        remove: function (key) {
            document.cookie = [key, '=', '', '; expires=-1'].join('');
        }
    };

    SAL.dom = {
        attrSupportCSS3: function (str) {
            var html = document.documentElement,
                style = html.style,
                css3s = 'Webkit Moz O ms'.split(' '),
                cstr = str.charAt(0).toUpperCase() + str.substr(1),
                rstr = (cstr + ' ' + css3s.join(cstr + ' ') + cstr).split(' '),
                result = null;
            for (var i = 0, len = rstr.length; i < len; i++) {
                if (rstr[i] in style) {
                    result = rstr[i];
                    break;
                }
            }
            return !!result;
        },
        getWinCoord: function () {
            var docElem = document.documentElement, docBody = document.body;
            return {
                ch: docElem.clientHeight || docBody.clientHeight,
                cw: docElem.clientWidth || docBody.clientWidth,
                st: docElem.scrollTop || docBody.scrollTop,
                sl: docElem.scrollLeft || docBody.scrollLeft
            };
        }
    };

    SAL.support = {
        css3_transform: function () {
            return SAL.dom.attrSupportCSS3('transform');
        }(),
        css3_3d: function () {
            var mod = 'modernizr',
                ret = SAL.dom.attrSupportCSS3('perspective'),
                injectElementWithStyles,
                docElement = document.documentElement;
            if (ret && 'webkitPerspective' in docElement.style) {
                injectElementWithStyles = function (rule, callback) {
                    var style, ret, node,
                        div = document.createElement('div'),
                        body = document.body,
                        fakeBody = body || document.createElement('body');
                    style = ['&#173;', '<style id="s', mod, '">', rule, '</style>'].join('');
                    div.id = mod;
                    (body ? div : fakeBody).innerHTML += style;
                    fakeBody.appendChild(div);
                    if (!body) {
                        fakeBody.style.background = "";
                        docElement.appendChild(fakeBody);
                    }
                    ret = callback(div, rule);
                    !body ? fakeBody.parentNode.removeChild(fakeBody) : div.parentNode.removeChild(div);
                    return !!ret;
                }
                injectElementWithStyles('@media (transform-3d),(-webkit-transform-3d){#modernizr{left:9px;position:absolute;height:3px;}}', function (node, rule) {
                    ret = node.offsetLeft === 9 && node.offsetHeight === 3;
                });
            }
            return ret;
        }(),
        fixed: function () {
            var container = document.body;
            if (document.createElement && container && container.appendChild && container.removeChild) {
                var el = document.createElement('div');
                if (!el.getBoundingClientRect) return null;
                el.innerHTML = 'x';
                el.style.cssText = 'position:fixed;top:100px;';
                container.appendChild(el);

                var originalHeight = container.style.height,
                    originalScrollTop = container.scrollTop;

                container.style.height = '3000px';
                container.scrollTop = 500;

                var elementTop = el.getBoundingClientRect().top;
                container.style.height = originalHeight;

                var isSupported = (elementTop === 100);
                container.removeChild(el);
                container.scrollTop = originalScrollTop;
                isSupported || $('html').css('background') || $('html').attr('style', 'background:url(about:blank) fixed no-repeat;');
                return isSupported;
            }
            return null;
        }()
    };

    /* 日期工具 */
    SAL.dateTools = {
        //根据字符串返回Date对象
        getDateByStr: function (str) {
            var date = new Date(str.replace(/-/ig, '/'));
            return !/Invalid/i.test(date.toString()) ? date : null;
        },
        //根据Date对象返回字符串
        getStrByDate: function (date, spec) {
            var strArr = [date.getFullYear(), date.getMonth() + 1, date.getDate()];
            return spec ? strArr.join('-') : strArr.concat([date.getHours(), date.getMinutes(), date.getSeconds(), date.getMilliseconds()]).join('-');
        },
        //根据毫秒数返回格式化的时长
        getFormatLength: function (val) {
            var d = Math.floor(val / 86400000),
                h,
                m,
                s,
                surplus = val;
            surplus = d ? surplus % 86400000 : surplus;
            h = Math.floor(surplus / 3600000);
            surplus = h ? surplus % 3600000 : surplus;
            m = Math.floor(surplus / 60000);
            surplus = m ? surplus % 60000 : surplus;
            s = Math.floor(surplus / 1000);
            surplus = s ? surplus % 1000 : surplus;

            return [d, h, m, s, surplus];
        },
        compare: function (date1, date2, format) {
            var diff = date1.valueOf() - date2.valueOf();
            return format ? SAL.dateTools.getFormatLength(new Date(0) - new Date(diff)) : diff;
        },
        clone: function (date) {
            return new Date(date);
        },
        //简单耗时统计
        timeConsuming: function () {
            var startTime;
            return {
                start: function () {
                    startTime = new Date();
                },
                onestep: function (log) {
                    var consuming = SAL.dateTools.compare(new Date(), startTime), output = '耗时总计' + consuming + '毫秒';
                    console && log && console.log(output);
                    return consuming;
                }
            }
        }()
    };

//分享
    SAL.Share = function (options) {
        this.setting = $.extend({
            target: null,
            weibo: {
                name: "新浪微博",
                url: "http://v.t.sina.com.cn/share/share.php"
            },
            txweibo: {
                name: "腾讯微博",
                url: "http://v.t.qq.com/share/share.php"
            }
        }, options);

        var _self = this, set = _self.setting;

        if (!set.target || !set.target.length) {
            return;
        }
        set.target.find("a").on('click', function () {
            var name = $(this).attr("name"),
                action = set[name] ? set[name].url : '',
                text = $('.product-title').text(),
                form = $([
                    '<form id="J-share-form" style="display:none;" target="_blank" action="' + action + '">',
                    '<input type="text" name="title" value="' + text + '" />',
                    '<input type="text" name="rtitle" value="' + text + '" />',
                    '<input type="text" name="url" value="' + location.href + '" />',
                    '<input type="text" name="rurl" value="' + location.href + '" />',
                    '<input type="text" name="link" value="' + location.href + '" />',
                    '<input type="text" name="rcontent" value="' + text + ' ' + location.href + '" />',
                    '<input type="text" name="site" value="http://springpass.china-sss.com/" />',
                    '</form>'
                ].join('')).appendTo('body').submit().remvoe();
            return false;
        });
    };


    /*
     *  团购倒计时
     *  $require  SAL.Class, SAL.dateTools
     *  @param options Object  配置参数对象
     *  options.target : jquery对象 需要date-timer-now和date-timer-end属性
     *  options.callback : 倒计时归0时触发的回调 
     *  otions.speed :  计时器速度，默认1000毫秒，最大接受50毫秒
     */
    SAL.GroupOnCountDown = function () {
        var queue = [],
            timerId,
            commomSpeed = 1000,
            serverStartDate, //服务器开始时间，用于确认真实时间
            clientStartDate, //客户端开始时间，用于计算时间差
            globalTimeGap;   //公共时间差， 指服务器时间和客户端时间的时间差
        return SAL.Class({
            init: function (speed) {
                if (!globalTimeGap || !clientStartDate || !serverStartDate) {
                    serverStartDate = this.serverStartDate;
                    clientStartDate = new Date();
                    globalTimeGap = this._dt.compare(serverStartDate, clientStartDate)
                }
                if (speed && speed < commomSpeed && speed > 50) {
                    commomSpeed = speed;
                    this.resetTimer();
                }
                queue.push(this);
                this.update(queue);
                timerId || this.timerStart();
            },
            timerReset: function () {
                clearInterval(timerId);
                timerId = null;
                this.timerStart();
            },
            timerStart: function () {
                var _this = this;
                timerId = setInterval(function () {
                    _this.update(queue);
                }, commomSpeed);
            },
            update: function (queue) {
                var dt = this._dt;
                $.each(queue, function (i, obj) {
                    var timeGap = dt.compare(obj.endDate, new Date) + globalTimeGap, timeGapFormat = [0, 0, 0, 0, 0];
                    if (timeGap > 0) {
                        timeGapFormat = dt.getFormatLength(timeGap);
                    } else {
                        obj.callback && obj.callback.apply(this.target);
                    }
                    obj.$J_D.text(timeGapFormat[0]);
                    obj.$J_H.text(timeGapFormat[1]);
                    obj.$J_M.text(timeGapFormat[2]);
                    obj.$J_S.text(timeGapFormat[3]);
                    obj.$J_MS.text(Math.random(timeGapFormat[4] / 100));
                });
            },
            _dt: SAL.dateTools,
            constructor: function (options) {
                var dt = this._dt
                target = this.target = options.target;
                try {
                    this.serverStartDate = dt.getDateByStr(target.attr('data-timer-now'));
                    this.endDate = dt.getDateByStr(target.attr('data-timer-end'));
                } catch (e) {
                    return;
                }
                ;
                this.callback = options.callback;
                this.$J_D = target.find('.J_D');
                this.$J_H = target.find('.J_H');
                this.$J_M = target.find('.J_M');
                this.$J_S = target.find('.J_S');
                this.$J_MS = target.find('.J_MS');
                this.init(options.speed);
            }
        });
    }();

//Page scroll to
    SAL.scrollTo = function (target, speed) {
        var target = target.length ? target.eq(0) : $(document.body), avg = 13, coordBegin = document.documentElement.scrollTop || document.body.scrollTop, coordEnd = target.offset().top, coordMean = (coordEnd - coordBegin) / (speed ? speed : avg) * avg, lib = {
            beginTime: (new Date()).getTime(),
            time: null,
            id: null,
            clean: function () {
                clearInterval(lib.id);
                window.scrollTo(0, coordEnd);
            },
            roll: function () {
                coordBegin += coordMean;
                lib.time = (new Date).getTime() - lib.beginTime;
                window.scrollTo(0, coordBegin);
                if (lib.time >= speed || (coordMean > 0 && coordBegin >= coordEnd) || (coordMean < 0 && coordBegin <= coordEnd)) {
                    lib.clean();
                }
            }
        };
        lib.id = setInterval(lib.roll, avg);
    };

//Zoom module
    SAL.Zoom = function (options) {
        this.init || $.extend(this.constructor.prototype, {
            fixLayout: function () {
                var mule = this.multiple, oImg = this.origin.find("img:visible"), vImg = this.viewer.show().find("img");
                this.origImg = oImg;
                this.viewImg = (vImg.length == 1 ? vImg : $('<img src="" alt="" />').appendTo(this.viewer)).attr({
                    src: oImg.attr("src"),
                    width: oImg.width() * mule,
                    height: oImg.height() * mule
                });
                this.zoomer.css({width: this.viewer.width() / mule, height: this.viewer.height() / mule}).show();
            }, getCurOffset: function (e) {
                return {left: e.pageX - this.origin.offset().left, top: e.pageY - this.origin.offset().top}
            }, getZoom: function (e) {
                var curOffset = this.getCurOffset(e);
                var minOffset = this.origImg.position();
                var maxOffset = {
                    left: minOffset.left + this.origImg.width() - this.zoomer.width(),
                    top: minOffset.top + this.origImg.height() - this.zoomer.height()
                };
                var curLeft = curOffset.left - minOffset.left - this.zoomer.width() / 2;
                var curTop = curOffset.top - minOffset.top - this.zoomer.height() / 2;
                this.zoomer.css({
                    left: curLeft < minOffset.left ? minOffset.left : curLeft > maxOffset.left ? maxOffset.left : curLeft,
                    top: curTop < minOffset.top ? minOffset.top : curTop > maxOffset.top ? maxOffset.top : curTop
                });
                this.lastXY = this.zoomer.offset();
                this.viewer[0].scrollLeft = this.zoomer.position().left * this.multiple;
                this.viewer[0].scrollTop = this.zoomer.position().top * this.multiple;
            }, initEvent: function () {
                var _self = this;
                this.origin.bind({
                    mouseover: function (e) {
                        _self.fixLayout();
                        _self.getZoom(e);
                    }, mousemove: function (e) {
                        _self.origImg || _self.fixLayout();
                        _self.getZoom(e);
                    }, mouseleave: function () {
                        _self.zoomer.hide();
                        _self.viewer.hide();
                    }
                });
            }, init: function (opts) {
                this.origin = opts.origin.css('position', 'relative');
                this.zoomer = opts.zoomer.css('position', 'absolute');
                this.viewer = opts.viewer;
                this.multiple = opts.multiple ? opts.multiple : 2;
                this.initEvent();
            }
        });
        this.init(options);
    };

//Tabs module
    SAL.Tabs = function (options) {
        this.setting = {
            tab: null, cont: null, event: "click", callback: function (e) {
            }
        };
        var set = $.extend(this.setting, options), event = set.event, hash = location.hash.replace(/^[#]*/, ""), tab = set.tab, hashTab = tab.filter("[lId=" + hash + "]");
        set.tab.bind(event, function () {
            var index = $(this).index(), lId = $(this).attr("lId");
            tab.removeClass("active").eq(index).addClass("active");
            set.cont.hide().eq(index).show();
            set.callback($(this));
            lId && (window.location.hash = lId);
            return false;
        });
        hashTab.length ? hashTab[event]() : tab.filter(".active")[event]();
    };

//Dialog module
    SAL.Dialog = function (options) {
        this.options = {
            target: null,
            mask: true,
            showType: '',
            easing: 'easeOutExpo',
            autoClose: false,
            autoCloseDelay: 5000,
            zIndex: 10000,
            scrollFollow: false,
            openBefore: function (e) {
            },
            closeBefore: function (e) {
            }
        };
        this.init || $.extend(this.constructor.prototype, {
            init: function (opts) {
                if (!opts.target && !opts.target.length) {
                    return;
                }
                ;
                $.extend(this.options, opts);
                $.data(document, 'db') || $.data(document, 'db', 0);
                var _self = this;
                opts.target.data('scrollFollow', this.options.scrollFollow).css('position', 'absolute').hide().find('.d-close').click(function () {
                    _self.close();
                });
                if (!$.data(document, 'dbEvent')) {
                    var tId, fixPosi = function () {
                        clearTimeout(tId);
                        tId = setTimeout(function () {
                            $('div.ui-dialog:visible').filter(function () {
                                return $(this).data('scrollFollow') === true;
                            }).position({alignX: 'center', alignY: 'center', type: 'slide'});
                        }, 2000);
                    };
                    $(window).on({scroll: fixPosi, resize: fixPosi});
                    $.data(document, 'dbEvent', true);
                }
            }, open: function () {
                var opts = this.options, _self = this;
                !$('#ui-fixmask').filter(':visible').length && opts.mask && SAL.mask.open();
                opts.openBefore(opts.target);
                opts.target.position({alignX: 'center', alignY: 'center'});
                if (opts.showType == 'slide' && !opts.force) {
                    opts.target.css({
                        marginTop: -$(window).height(),
                        'zIndex': opts.zIndex + $('div.ui-dialog:visible').length + 1
                    }).show().animate({marginTop: 0}, 500, opts.easing);
                }
                if (opts.showType == 'fade' && !$.SAL.isQuirk) {
                    opts.target.fadeIn();
                } else {
                    opts.target.show();
                }
                ;
                $.data(document, 'db', $.data(document, 'db') + 1);
                if (opts.autoClose) {
                    var tId, cd = opts.autoCloseDelay / 1000, $cd = opts.target.find('.cd').text(cd);
                    if ($cd.length) {
                        tId = setInterval(function () {
                            cd--;
                            if (cd == 0) {
                                clearInterval(tId);
                            } else {
                                $cd.text(cd);
                            }
                        }, 1000);
                    }
                    setTimeout(function () {
                        _self.close();
                    }, opts.autoCloseDelay);
                }
            }, close: function () {
                var opts = this.options;
                if (opts.target.is(':hidden')) {
                    return;
                }
                ;
                opts.closeBefore(opts.target);
                if (opts.showType == 'slide' && !opts.force) {
                    opts.target.animate({marginTop: -$(window).height()}, 500, opts.easing, function () {
                        $(this).hide();
                    });
                } else if (opts.showType == 'fade' && !$.SAL.isQuirk) {
                    opts.target.fadeOut();
                } else {
                    opts.target.hide();
                }
                $.data(document, 'db', $.data(document, 'db') - 1);
                $(document).data('db') == 0 && opts.mask && $('#ui-fixmask').hide();
            }
        });
        this.init(options);
    };

//mask
    SAL.mask = {
        open: function () {
            if (!$('#ui-fixmask').length) {
                $('<div id="ui-fixmask"><iframe src="" scrolling="no" frameborder="0" style="opacity:0;filter:alpha(opacity=0);width:100%;height:100%;position:absolute;left:0;top:0;"></iframe></div>').attr('style', 'width:100%;height:100%;' + [!$.SAL.isQuirk ? "position:fixed;left:0;top:0;bottom:0;" : "position:absolute;top:expression(documentElement.scrollTop);left:expression(documentElement.scrollLeft);_height:expression(documentElement.clientHeight);"].join('') + 'background:#000;opacity:0.3;filter:alpha(opacity=30);z-index:9998;display:none;').appendTo('body');
                $.SAL.initQuirk();
            }
            $('#ui-fixmask').show();
        }, close: function () {
            $('#ui-fixmask').hide();
        }
    };

//信息弹出框封装
    SAL.dialogMsg = function (options) {
        var _self = arguments.callee;
        var opts = options ? options : {};
        var db = _self.db ? _self.db : _self.db = new SAL.Dialog({
                target: $([
                    '<div class="ui-dialog msg-dialog">',
                    '<a href="javascript:;" class="d-close">关闭</a>',
                    '<div class="d-title">友情提醒</div>',
                    '<div class="d-inner">',
                    '<div class="btn-group">',
                    '<button type="button" class="ui-btn-orange">我知道了</button>',
                    '</div>',
                    '</div>',
                    '</div>'
                ].join('')).appendTo($('body'))
            });

        var target = db.options.target;
        target.css({
            width: parseFloat(opts.width) + "px",
            height: parseFloat(opts.height) + "px"
        });

        target.find('.d-title').html(opts.title ? opts.title : "");
        target.find('.d-inner').html(opts.content ? opts.content : "");

        db.options.openBefore = opts.openBefore ? opts.openBefore : function (e) {
            };
        db.options.closeBefore = opts.closeBefore ? opts.closeBefore : function (e) {
            };

        if (opts.autoClose) {
            target.find('.d-inner').append('<p>倒计时<span class="cd">5</span>秒返回当前页面</p>');
            db.options.autoClose = true;
            db.options.autoCloseDelay = opts.autoCloseDelay || 5000;
        } else {
            db.options.autoClose = false;
        }

        if (opts.button) {
            var frag = document.createDocumentFragment();

            target.find(".btn-group").remove();

            for (var d in opts.button) {
                var fn = opts.button[d] instanceof Function ? opts.button[d] : function () {
                    };
                (function (fn) {
                    frag.appendChild($('<button type="button" class="ui-btn-orange">' + d + '</button>').click(function () {
                        if (!!!fn(target)) {
                            db.close();
                        }
                        return false;
                    })[0]);
                }(fn));
            }

            target.find('.d-inner').append($('<div class="btn-group"></div>').append($(frag)));
        }

        db.open();
    };

    /* module : Slides (required jQuery.js, SAL.Core.js) */
    (function ($) {
        var defaults = {
            $slider: null,
            $pager: null,
            $prev: null,
            $next: null,
            fx: 'vertical',
            speed: 500,
            timeout: 5000,
            before: null,
            after: null,
            easing: 'easeOutExpo',
            pagerEvent: 'hover',
            exposSlide: true,
            cycleSlide: true,
            queuePager: false,
            speedIn: null,
            speedOut: null,
            easeIn: null,
            easeOut: null,
            lastIndex: 0,
            cssBefore: {},
            cssAfter: {},
            animateIn: {},
            animateOut: {},
            currPagerClass: 'active'
        };
        SAL.Slides = SAL.Class({
            constructor: function (options) {
                var data = this.data = $.extend({}, defaults, options),
                    $slider = data.$slider;
                if ((data.length = $slider.length) > 1) {
                    if (!/absolute|relative/.test($slider.parent().css('position'))) {
                        $slider.parent().css({position: 'relative', zoom: 1});
                    }
                    $slider.css({position: 'absolute', top: 0, left: 0}).hide().eq(data.lastIndex).show();
                    data.speedIn = data.speedIn || data.speed;
                    data.speedOut = data.speedOut || data.speed;
                    data.easeIn = data.easeIn || data.easing;
                    data.easeOut = data.easeOut || data.easing;
                    data.easeIn = $.easing[data.easeIn] ? data.easeIn : null;
                    data.easeOut = $.easing[data.easeOut] ? data.easeOut : null;
                    this.initEvent(data);
                    this.initStart(data);
                }
            },
            effects: {
                fade: function ($curr, $next, data) {
                    //data.$slider.css({ zIndex : 0, opacity : 0});
                    data.cssBefore = {opacity: 0};
                    data.animateIn = {opacity: 1};
                    data.animateOut = {opacity: 0};
                },
                horizontal: function ($curr, $next, data) {
                    var advance = $curr.index() < $next.index() ? 1 : -1;
                    data.cssBefore = {left: advance * $next.width()};
                    data.animateIn = {left: 0};
                    data.animateOut = {left: advance * -$curr.width()};
                },
                vertical: function ($curr, $next, data) {
                    var advance = $curr.index() < $next.index() ? 1 : -1;
                    data.cssBefore = {top: advance * $next.height()};
                    data.animateIn = {top: 0};
                    data.animateOut = {top: advance * -$curr.height()};
                },

                roll: function ($curr, $next, data) {
                    if (!SAL.support.css3_3d) {
                        return SAL.Slides.prototype.effects.vertical($curr, $next, data);
                    }
                    ;
                    if (!arguments.callee.getTransform) {
                        arguments.callee.getTransform = function (deg, width, speed) {
                            var prefix,
                                transitionCss = {},
                                transformCss = {opacity: 1 - Math.abs(deg) / 90};
                            if ($.browser.opera) {
                                prefix = '-o-';
                            } else if ($.browser.msie) {
                                prefix = '-ms-';
                            } else if ($.browser.webkit) {
                                prefix = '-webkit-';
                            } else if ($.browser.mozilla) {
                                prefix = '-moz-';
                            }
                            transformCss[prefix + 'transform'] = 'perspective(' + width + 'px) rotateY(' + deg + 'deg)';
                            transitionCss[prefix + 'transition'] = 'all ' + Math.round(speed / 100) / 10 + 's';
                            return [transformCss, transitionCss];
                        };
                    }
                    var getTransform = arguments.callee.getTransform;
                    currStyle = getTransform(90, $curr.width() * 3, data.speedOut),
                        nextStyle = getTransform(0, $next.width() * 3, data.speedIn);
                    data.$slider.show().css(currStyle[0]);
                    setTimeout(function () {
                        $next.css(nextStyle[0]);
                        data.$slider.css(nextStyle[1]);
                    }, 0);
                },
                normal: function ($curr, $next, data) {
                    data.$slider.hide();
                    $next.show();
                }
            },
            slide: function (data, index) {
                var effect = this.effects[data.fx] || this.effects.normal,
                    index = typeof index == 'number' ? index : this.getNextIndex(1),
                    _this = this,
                    $slider = data.$slider,
                    $curr = $slider.eq(data.lastIndex),
                    $next = $slider.eq(index);
                if (data.stop || data.lastIndex == index || $slider.parent().is(':hidden')) {
                    data.stop && data.queuePager && (data.queue = $next);
                    return;
                }
                data.$pager.removeClass(data.currPagerClass).eq(index).addClass(data.currPagerClass);
                data.$slider.stop(true, true);
                data.stop = data.queuePager;
                effect($curr, $next, data);
                $.isFunction(data.before) && data.before($curr, $next, data);
                $next.show().css(data.cssBefore).animate(data.animateIn, data.speedIn, data.easeIn, function () {
                    $.isFunction(data.after) && data.after($curr, $next, data);
                    data.stop = 0;
                    if (data.queue) {
                        _this.slide(data, data.$slider.index(data.queue));
                        data.queue = null;
                    }
                });
                $curr.animate(data.animateOut, data.speedOut, data.easeOut, function () {
                    $(this).css(data.cssAfter);
                });
                data.lastIndex = $slider.index($next);
            },
            getNextIndex: function (advance) {
                var data = this.data;
                return advance > 0 ? (data.length > data.lastIndex + advance ? data.lastIndex + advance : 0) : (0 > data.lastIndex + advance ? data.length - 1 : data.lastIndex + advance);
            },
            initStart: function (data) {
                var _this = this;
                if (data.cycleSlide && !data.tId) {
                    data.tId = setInterval(function () {
                        data.stopCycle || _this.slide(data);
                    }, data.timeout);
                }
            },
            initEvent: function (data) {
                var _this = this;
                $(data.$next).click(function () {
                    _this.slide(data, _this.getNextIndex(1));
                });
                $(data.$prev).click(function () {
                    _this.slide(data, _this.getNextIndex(-1));
                });
                $(data.$pager)[data.pagerEvent](function () {
                    _this.slide(data, data.$pager.index($(this)));
                });
                if (data.exposSlide) {
                    $(data.$pager).add(data.$next).add(data.$prev).add(data.$slider).hover(function () {
                        data.stopCycle = 1;
                    }, function () {
                        data.stopCycle = 0;
                    });
                }
            },
            STATIC: {
                extendFx: function (fxObject) {
                    $.extend(SAL.Slides.prototype.effects, fxObject);
                }
            }
        });
    })(jQuery);


})(jQuery);


//sinmulate select
;(function ($, S1, S2, F1, F2, H1, O1, H2, H3) {
    $.fn.simSelect = function (options) {
        var setting = $.extend({width: null, height: 21, maxCount: 5, animated: false}, options);
        return this.each(function () {
            var arrOption = [];
            var selectedValue;
            var selectedText;
            var $self = $(this);
            var name = $self.attr("name");
            var id = $self.attr("id") || "";
            var textName = "simText-" + name;
            var textId = id ? "simText-" + id : "";
            $self.find("option").each(function () {
                var val = $(this).val(), text = $(this).text();
                if ($(this).prop('selected')) {
                    arrOption.push('<li class="el-option el-option-hover" val="' + val + '">' + text + '</li>');
                    selectedValue = val;
                    selectedText = text;
                } else {
                    arrOption.push('<li class="el-option" val="' + val + '">' + text + '</li>');
                }
            });
            var $simWrap = $('<fieldset class="sim-select" tabindex="0"></fieldset>');
            var $simSelect = $('<legend class="el-select">' + selectedText + '</legend>');
            var $simOl = $('<ol></ol>');
            var $simOption = $simOl.html(arrOption.join('')).find(O1);
            var $input = $('<input type="hidden" name="' + name + '" value="' + selectedValue + '" />').add('<input type="hidden" name="' + textName + '"  value="' + selectedText + '" />');
            id && $input.eq(0).attr('id', id) && $input.eq(1).attr('id', textId);
            $self.after($simWrap.append($simSelect).append($input).append($simOl));
            var width = setting.width || $self.outerWidth() - 20;
            var height = setting.height;
            $simSelect.css({width: width, height: height, lineHeight: height + 'px'});
            $simOl.css({
                width: $simSelect.outerWidth() - 2,
                height: $simOption.length > setting.maxCount ? height * setting.maxCount : height * $simOption.length,
                lineHeight: height + 'px'
            }).hide().data("animated", !($.browser.msie && $.browser.version == '6.0') && setting.animated) && $self.remove();
        });
    };
    function _init() {
        var simSelect = $(S1);
        simSelect.find('ol').hide();
        simSelect.find(S2).removeClass(F2);
    };
    function _change(elem, blur) {
        var $simWrap = elem.closest(S1), $input = $simWrap.find("input:hidden"), $simSelect = $simWrap.find(S2), val = elem.attr('val'), text = elem.text();
        if ($input.eq(0).val() != val || $input.eq(1).val() != text) {
            $input.eq(0).val(val) && $input.eq(1).val(text) && $simWrap.change();
        }
        setTimeout(function () {
            $simSelect.text($input.eq(1).val());
            blur || $simSelect.addClass(F2);
        }, 0);
    };
    $(document).on({
        keydown: function (e) {
            var _act = $(F1), _ol = _act.closest(S1).find('ol'), _op = _ol.find(O1), _actOp = _op.filter(H2), _actMax = _op.length - 1, _actIdx = _actOp.index(), _drNum = _ol.height() / _actOp.height();
            if (/38|40|9/.test(e.keyCode) && _act.length) {
                if (e.keyCode == 40) {
                    _act.text((_actOp = _op.removeClass(H3).eq(_actIdx + 1 >= _actMax ? _actMax : _actIdx + 1).addClass(H3)).text()) && _actOp.offset().top > _ol.offset().top + _actOp.outerHeight() * (_drNum) && _ol.scrollTop(_actOp.outerHeight() * (_actOp.index() + 1 - _drNum));
                } else if (e.keyCode == 38) {
                    _act.text((_actOp = _op.removeClass(H3).eq(_actIdx - 1 < 1 ? 0 : _actIdx - 1)).addClass(H3).text()) && _actOp.offset().top < _ol.offset().top && _ol.scrollTop(_actOp.outerHeight() * (_actOp.index()));
                } else {
                    _init();
                }
            }
        }, keypress: function (e) {
            e.keyCode == 13 && $(F1).length && $(F1).closest(S1).find(H2).click().closest(S1).focus() && _change($(F1).closest(S1).find(H2));
        }, click: function (e) {
            !$(e.target).hasClass('el-select') && _init();
        }
    }).delegate(S1, {
        focus: function () {
            _init() || $(this).find(S2).addClass(F2);
        }, blur: function () {
            _change($(this).removeClass(F2).find(H2), true);
            _init();
        }
    }).delegate(S2, {
        click: function () {
            var _self = $(this), _actOp, _actPos, _maxPos, _ol, _op = _self.closest(S1).find(O1);
            if (!_init() && !_self.hasClass(F2)) {
                _ol = _self.addClass(F2) && _op.removeClass(H3).each(function () {
                        $(this).text() === _self.text() && (_actOp = $(this).addClass(H3));
                    }).closest('ol');
                _ol.data('animated') && _ol[0] !== $.data(document, 'lastShowOl') ? _ol.slideDown() : _ol.show();
                _actPos = _actOp.index() * _actOp.outerHeight();
                _maxPos = _op.length * _actOp.outerHeight() - _ol.height() - 1;
                _ol.scrollTop(_actPos >= _maxPos ? _maxPos : _actPos);
                $.data(document, 'lastShowOl', _ol[0]);
            }
        }
    }).delegate(O1, {
        mousedown: function () {
            _change($(this));
        }, mouseover: function () {
            if (!$(this).hasClass(H3)) {
                $(this).closest(S1).find(O1).removeClass(H3);
                $(this).addClass(H3);
            }
        }
    });
}(jQuery, 'fieldset.sim-select', 'legend.el-select', 'legend.el-select-focus', 'el-select-focus', 'el-select-hover', 'li.el-option', 'li.el-option-hover', 'el-option-hover'));

//easing extend
(function ($) {
    $.extend($.easing, {
        easeInQuad: function (x, t, b, c, d) {
            return c * (t /= d) * t + b
        }, easeOutQuad: function (x, t, b, c, d) {
            return -c * (t /= d) * (t - 2) + b
        }, easeInOutQuad: function (x, t, b, c, d) {
            if ((t /= d / 2) < 1)return c / 2 * t * t + b;
            return -c / 2 * ((--t) * (t - 2) - 1) + b
        }, easeInCubic: function (x, t, b, c, d) {
            return c * (t /= d) * t * t + b
        }, easeOutCubic: function (x, t, b, c, d) {
            return c * ((t = t / d - 1) * t * t + 1) + b
        }, easeInOutCubic: function (x, t, b, c, d) {
            if ((t /= d / 2) < 1)return c / 2 * t * t * t + b;
            return c / 2 * ((t -= 2) * t * t + 2) + b
        }, easeInQuart: function (x, t, b, c, d) {
            return c * (t /= d) * t * t * t + b
        }, easeOutQuart: function (x, t, b, c, d) {
            return -c * ((t = t / d - 1) * t * t * t - 1) + b
        }, easeInOutQuart: function (x, t, b, c, d) {
            if ((t /= d / 2) < 1)return c / 2 * t * t * t * t + b;
            return -c / 2 * ((t -= 2) * t * t * t - 2) + b
        }, easeInQuint: function (x, t, b, c, d) {
            return c * (t /= d) * t * t * t * t + b
        }, easeOutQuint: function (x, t, b, c, d) {
            return c * ((t = t / d - 1) * t * t * t * t + 1) + b
        }, easeInOutQuint: function (x, t, b, c, d) {
            if ((t /= d / 2) < 1)return c / 2 * t * t * t * t * t + b;
            return c / 2 * ((t -= 2) * t * t * t * t + 2) + b
        }, easeInSine: function (x, t, b, c, d) {
            return -c * Math.cos(t / d * (Math.PI / 2)) + c + b
        }, easeOutSine: function (x, t, b, c, d) {
            return c * Math.sin(t / d * (Math.PI / 2)) + b
        }, easeInOutSine: function (x, t, b, c, d) {
            return -c / 2 * (Math.cos(Math.PI * t / d) - 1) + b
        }, easeInExpo: function (x, t, b, c, d) {
            return (t == 0) ? b : c * Math.pow(2, 10 * (t / d - 1)) + b
        }, easeOutExpo: function (x, t, b, c, d) {
            return (t == d) ? b + c : c * (-Math.pow(2, -10 * t / d) + 1) + b
        }, easeInOutExpo: function (x, t, b, c, d) {
            if (t == 0)return b;
            if (t == d)return b + c;
            if ((t /= d / 2) < 1)return c / 2 * Math.pow(2, 10 * (t - 1)) + b;
            return c / 2 * (-Math.pow(2, -10 * --t) + 2) + b
        }, easeInCirc: function (x, t, b, c, d) {
            return -c * (Math.sqrt(1 - (t /= d) * t) - 1) + b
        }, easeOutCirc: function (x, t, b, c, d) {
            return c * Math.sqrt(1 - (t = t / d - 1) * t) + b
        }, easeInOutCirc: function (x, t, b, c, d) {
            if ((t /= d / 2) < 1)return -c / 2 * (Math.sqrt(1 - t * t) - 1) + b;
            return c / 2 * (Math.sqrt(1 - (t -= 2) * t) + 1) + b
        }, easeInElastic: function (x, t, b, c, d) {
            var s = 1.70158;
            var p = 0;
            var a = c;
            if (t == 0)return b;
            if ((t /= d) == 1)return b + c;
            if (!p) p = d * .3;
            if (a < Math.abs(c)) {
                a = c;
                var s = p / 4
            } else var s = p / (2 * Math.PI) * Math.asin(c / a);
            return -(a * Math.pow(2, 10 * (t -= 1)) * Math.sin((t * d - s) * (2 * Math.PI) / p)) + b
        }, easeOutElastic: function (x, t, b, c, d) {
            var s = 1.70158;
            var p = 0;
            var a = c;
            if (t == 0)return b;
            if ((t /= d) == 1)return b + c;
            if (!p) p = d * .3;
            if (a < Math.abs(c)) {
                a = c;
                var s = p / 4
            } else var s = p / (2 * Math.PI) * Math.asin(c / a);
            return a * Math.pow(2, -10 * t) * Math.sin((t * d - s) * (2 * Math.PI) / p) + c + b
        }, easeInOutElastic: function (x, t, b, c, d) {
            var s = 1.70158;
            var p = 0;
            var a = c;
            if (t == 0)return b;
            if ((t /= d / 2) == 2)return b + c;
            if (!p) p = d * (.3 * 1.5);
            if (a < Math.abs(c)) {
                a = c;
                var s = p / 4
            } else var s = p / (2 * Math.PI) * Math.asin(c / a);
            if (t < 1)return -.5 * (a * Math.pow(2, 10 * (t -= 1)) * Math.sin((t * d - s) * (2 * Math.PI) / p)) + b;
            return a * Math.pow(2, -10 * (t -= 1)) * Math.sin((t * d - s) * (2 * Math.PI) / p) * .5 + c + b
        }, easeInBack: function (x, t, b, c, d, s) {
            if (s == undefined) s = 1.70158;
            return c * (t /= d) * t * ((s + 1) * t - s) + b
        }, easeOutBack: function (x, t, b, c, d, s) {
            if (s == undefined) s = 1.70158;
            return c * ((t = t / d - 1) * t * ((s + 1) * t + s) + 1) + b
        }, easeInOutBack: function (x, t, b, c, d, s) {
            if (s == undefined) s = 1.70158;
            if ((t /= d / 2) < 1)return c / 2 * (t * t * (((s *= (1.525)) + 1) * t - s)) + b;
            return c / 2 * ((t -= 2) * t * (((s *= (1.525)) + 1) * t + s) + 2) + b
        }, easeInBounce: function (x, t, b, c, d) {
            return c - $.easing.easeOutBounce(x, d - t, 0, c, d) + b
        }, easeOutBounce: function (x, t, b, c, d) {
            if ((t /= d) < (1 / 2.75)) {
                return c * (7.5625 * t * t) + b
            } else if (t < (2 / 2.75)) {
                return c * (7.5625 * (t -= (1.5 / 2.75)) * t + .75) + b
            } else if (t < (2.5 / 2.75)) {
                return c * (7.5625 * (t -= (2.25 / 2.75)) * t + .9375) + b
            } else {
                return c * (7.5625 * (t -= (2.625 / 2.75)) * t + .984375) + b
            }
        }, easeInOutBounce: function (x, t, b, c, d) {
            if (t < d / 2)return $.easing.easeInBounce(x, t * 2, 0, c, d) * .5 + b;
            return $.easing.easeOutBounce(x, t * 2 - d, 0, c, d) * .5 + c * .5 + b
        }
    })
})(jQuery);


//position plugin
;(function ($) {
    var _position = $.fn.position;
    $.fn.position = function (options) {
        if (!options || options.constructor !== Object) {
            return _position.apply(this);
        }
        ;
        var op = $.extend({
            offset: [0, 0],
            type: 'normal',
            easing: null,
            speed: 1000,
            style: {},
            at: null,
            easing: null
        }, options);
        return this.each(function () {
            if (op.type == 'force') {
                $(this).fixator(op);
                return;
            }
            ;
            var my = $(this).css('position', 'absolute'), at = op.at || document.body, sire = $(this).offsetParent(), diff = {
                top: at.scrollTop || document.documentElement.scrollTop,
                left: at.scrollLeft || document.documentElement.scrollLeft
            }, style = op.style;
            at = at == document.body && window;
            style.left = (op.alignX == 'center' ? (($(at).width() - my.width()) / 2) : op.alignX == 'right' ? $(at).width() - $(this).width() : 0) + op.offset[0] + diff.left - sire.offset().left;
            style.top = (op.alignY == 'center' ? (($(at).height() - my.height()) / 2) : op.alignY == 'bottom' ? $(at).height() - $(this).height() : 0) + op.offset[1] + diff.top - sire.offset().top;
            op.type == 'slide' ? my.animate(style, op.speed, op.easing) : my.css(style);
        });
    };
    $.fn.fixator = function (options) {
        $.SAL.initQuirk();
        return this.each(function () {
            var $self = $(this).css('position', 'absolute'), css = options.style;
            if (options.alignX == 'center') {
                css.left = '50%';
                css.marginLeft = -$self.width() / 2;
            } else {
                css[options.alignX] = 0 + options.offset[0];
            }
            ;
            if (options.alignY == 'center') {
                css.marginTop = ($(window).height() - $self.height()) / 2;
                $self.data('alignEvent', function () {
                    $self.css('marginTop', ($(window).height() - $self.height()) / 2);
                });
                $(window).bind('resize', $self.data('alignEvent'));
            } else {
                css[options.alignY] = 0 + options.offset[1];
            }
            ;
            $.SAL.fixator(options).append($self.css(css));
        });
    };
    $.extend($.SAL, {
        fixator: function (options) {
            if (!$('#ui-fixlayout').length) {
                var old = $.SAL.isQuirk, left = old ? 'expression(documentElement.scrollLeft)' : 0, top = old ? 'expression(documentElement.scrollTop)' : 0, bottom = old ? 'top:expression(documentElement.scrollTop + documentElement.clientHeight - this.offsetHeight);' : 'bottom:0;', position = old ? 'absolute' : 'fixed';
                $('<div id="ui-fixlayout"></div>').append($('<div></div>').attr('style', 'width:100%;height:0;left:' + left + ';top:' + top + ';position:' + position + ';z-index:9999;').append('<div id="fixator-top" style="position:relative;height:0;"></div>')).append($('<div></div>').attr('style', 'width:100%;height:0;left:' + left + ';' + bottom + 'position:' + position + ';z-index:9999;').append('<div id="fixator-bottom" style="position:relative;height:0;"></div>')).prependTo($('body'));
            }
            ;
            if (options.alignY == 'bottom') {
                return $('#fixator-bottom');
            } else {
                return $('#fixator-top');
            }
        }, isQuirk: $.browser.msie && $.browser.version == '6.0', initQuirk: function () {
            $.SAL.isQuirk && $('html').css('background') || $('html').css('background', 'url(about:blank) fixed no-repeat;');
        }
    });
}(jQuery));

//lazyload plugin
;(function ($) {
    $.fn.lazyload = function (options) {
        var settings = {threshold: 0, failurelimit: 0, event: "scroll", effect: "show", container: window};
        if (options) {
            $.extend(settings, options);
        }
        ;
        var elements = this;
        if ("scroll" == settings.event) {
            $(settings.container).bind("scroll", function (event) {
                var counter = 0;
                elements.each(function () {
                    if ($.abovethetop(this, settings) || $.leftofbegin(this, settings)) {
                    } else if (!$.belowthefold(this, settings) && !$.rightoffold(this, settings)) {
                        $(this).trigger("appear");
                    } else {
                        if (counter++ > settings.failurelimit) {
                            return false;
                        }
                    }
                });
                var temp = $.grep(elements, function (element) {
                    return !element.loaded;
                });
                elements = $(temp);
            });
        }
        ;
        this.each(function () {
            var self = this;
            if (undefined == $(self).attr("original")) {
                $(self).attr("original", $(self).attr("src"));
            }
            if ("scroll" != settings.event || undefined == $(self).attr("src") || settings.placeholder == $(self).attr("src") || ($.abovethetop(self, settings) || $.leftofbegin(self, settings) || $.belowthefold(self, settings) || $.rightoffold(self, settings))) {
                if (settings.placeholder) {
                    $(self).attr("src", settings.placeholder);
                } else {
                    $(self).removeAttr("src");
                }
                ;
                self.loaded = false;
            } else {
                self.loaded = true;
            }
            $(self).one("appear", function () {
                if (!this.loaded) {
                    $("<img />").bind("load", function () {
                        $(self).hide().attr("src", $(self).attr("original"))[settings.effect](settings.effectspeed);
                        self.loaded = true;
                    }).attr("src", $(self).attr("original"));
                }
                ;
            });
            if ("scroll" != settings.event) {
                $(self).bind(settings.event, function (event) {
                    if (!self.loaded) {
                        $(self).trigger("appear");
                    }
                });
            }
        });
        $(settings.container).trigger(settings.event);
        return this;
    };
    $.belowthefold = function (element, settings) {
        if (settings.container === undefined || settings.container === window) {
            var fold = $(window).height() + $(window).scrollTop();
        } else {
            var fold = $(settings.container).offset().top + $(settings.container).height();
        }
        return fold <= $(element).offset().top - settings.threshold;
    };
    $.rightoffold = function (element, settings) {
        if (settings.container === undefined || settings.container === window) {
            var fold = $(window).width() + $(window).scrollLeft();
        } else {
            var fold = $(settings.container).offset().left + $(settings.container).width();
        }
        return fold <= $(element).offset().left - settings.threshold;
    };
    $.abovethetop = function (element, settings) {
        if (settings.container === undefined || settings.container === window) {
            var fold = $(window).scrollTop();
        } else {
            var fold = $(settings.container).offset().top;
        }
        return fold >= $(element).offset().top + settings.threshold + $(element).height();
    };
    $.leftofbegin = function (element, settings) {
        if (settings.container === undefined || settings.container === window) {
            var fold = $(window).scrollLeft();
        } else {
            var fold = $(settings.container).offset().left;
        }
        return fold >= $(element).offset().left + settings.threshold + $(element).width();
    };
    $.extend($.expr[':'], {
        "below-the-fold": "$.belowthefold(a, {threshold : 0, container: window})",
        "above-the-fold": "!$.belowthefold(a, {threshold : 0, container: window})",
        "right-of-fold": "$.rightoffold(a, {threshold : 0, container: window})",
        "left-of-fold": "!$.rightoffold(a, {threshold : 0, container: window})"
    });
})(jQuery);


$(function () {

    $('select.J_Simulate').simSelect();

    $('span.J_Watermark').click(function () {
        $(this).parent().find('input').focus();
    })
        .parent().find('input').bind({
        focus: function () {
            $(this).parent().find('.J_Watermark').hide();
        },
        blur: function () {
            $(this).val() || $(this).parent().find('.J_Watermark').show();
        }
    }).focus().blur();

    $('#J_MyInfo').hover(function () {
        $(this).addClass('my-info-active').find('ul').show();
    }, function () {
        $(this).removeClass('my-info-active').find('ul').hide();
    });

    $('#J_Menu').hover(function () {
        $(this).find('.m-inner').show();
        $('#J_Menu').addClass('active');
    }, function () {
        $(this).find('.m-inner').hide();
        $('#J_Menu').removeClass('active');
    });

    $('.J_InpText input').delegate($(document), {
        focus: function () {
            $(this).addClass('active');
        },
        blur: function () {
            $(this).removeClass('active');
        }
    });

    if ($('#J_LoginDialog').length) {
        window.loginDialog = new SAL.Dialog({
            target: $('#J_LoginDialog')
        });
    }

    ~function () {
        var $gotop = $('#J_GoTop'), tId;

        function gotopHandle() {
            clearTimeout(tId);
            $gotop.stop(true, true).fadeOut(0);
            setTimeout(function () {
                var coord = SAL.dom.getWinCoord();
                if (coord.st > coord.ch) {
                    if (SAL.support.fixed) {
                        $gotop.data('fix') || $gotop.css({position: 'fixed', right: 0, bottom: 0}).data('fix', true);
                    } else {
                        $gotop.css({
                            position: 'absolute',
                            top: coord.st + coord.ch - $gotop.height(),
                            left: coord.sl + coord.cw - $gotop.width()
                        });
                    }
                    $gotop.fadeIn();
                }
            }, 500);
        }

        $(window).on({
            scroll: gotopHandle,
            resize: gotopHandle
        }).scroll();
        $gotop.click(function () {
            SAL.scrollTo($('body'), 500);
            return false;
        });
    }();


});