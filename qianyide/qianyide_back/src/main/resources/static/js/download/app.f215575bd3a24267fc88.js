webpackJsonp([1], {
    "6cqk": function (t, n) {
    }, NHnr: function (t, n, e) {
        "use strict";
        Object.defineProperty(n, "__esModule", {value: !0});
        var a = e("/5sW"), r = {
            render: function () {
                var t = this.$createElement, n = this._self._c || t;
                return n("div", {attrs: {id: "app"}}, [n("router-view")], 1)
            }, staticRenderFns: []
        };
        var s = e("VU/8")({name: "App"}, r, !1, function (t) {
            e("UpNU")
        }, null, null).exports, o = e("mtWM"), i = e.n(o), c = e("/ocq"), l = {
            name: "HelloWorld", data: function () {
                return {os: null}
            }, methods: {
                target: function (t) {
                    var n = this.$refs.target;
                    n.setAttribute("href", t), n.click()
                }, androidEvent: function () {
                    var t = this;
                    this.as.post(this.sever.url("renewVersion"), {os: 0}).then(function (n) {
                        t.target(n.data.result.downloadUrl)
                    }).catch(function (t) {
                        alert(t.data)
                    })
                }, iosEvent: function () {
                    var t = this;
                    this.as.post(this.sever.url("renewVersion"), {os: 1}).then(function (n) {
                        t.target(n.data.result.downloadUrl)
                    }).catch(function (t) {
                        alert(t.data)
                    })
                }
            }
        }, u = {
            render: function () {
                var t = this, n = t.$createElement, a = t._self._c || n;
                return a("div", {staticClass: "wrap"}, [a("img", {
                    staticClass: "logo",
                    attrs: {src: e("dLd/"), alt: ""}
                }), t._v(" "), a("h2", {staticClass: "logotext"}, [t._v("加速卡")]), t._v(" "), a("p", {staticClass: "slogen"}, [t._v("全程线上申请，机器审核，易通过；5分钟审核到账；银行级别加密方式，保障用户信息安全。")]), t._v(" "), a("div", {staticClass: "btn-content"}, [a("div", {
                    staticClass: "btn",
                    on: {click: t.androidEvent}
                }, [a("i", {staticClass: "iconfont icon-anzhuo"}), t._v(" "), a("p", [t._v("Android版下载")])]), t._v(" "), a("div", {
                    staticClass: "btn",
                    staticStyle: {"margin-top": ".6rem"},
                    on: {click: t.iosEvent}
                }, [a("i", {staticClass: "iconfont icon-ios"}), t._v(" "), a("p", [t._v("iPhone版下载")])])]), t._v(" "), a("p", {staticClass: "corporate"}, [t._v("宿迁才聚网络科技有限公司")]), t._v(" "), a("a", {
                    ref: "target",
                    staticStyle: {display: "block"},
                    attrs: {href: "", target: "_blank"}
                })])
            }, staticRenderFns: []
        };
        var d = e("VU/8")(l, u, !1, function (t) {
            e("6cqk")
        }, "data-v-3aa659e6", null).exports;
        a.a.use(c.a);
        var v = new c.a({routes: [{path: "/", name: "HelloWorld", component: d}]}), p = (e("Q0/0"), e("aNHt")),
            f = e.n(p);
        i.a.defaults.headers.post["Content-Type"] = "multipart/form-data", a.a.prototype.sever = f.a, a.a.prototype.as = i.a, a.a.config.productionTip = !1, new a.a({
            el: "#app",
            router: v,
            render: function (t) {
                return t(s)
            }
        })
    }, "Q0/0": function (t, n) {
    }, UpNU: function (t, n) {
    }, aNHt: function (t, n) {
        t.exports = {
            url: function (t) {
                return "" + t
            }
        }
    }, "dLd/": function (t, n, e) {
        t.exports = e.p + "images/logo.8894cc0.png"
    }
}, ["NHnr"]);