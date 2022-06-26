define(["c-conf", "c-yi-remote"], function(conf, yiRemote) {

    "use strict";

    $(function() {
        $("#send-code").width($("#send-code").width());
    });

    $("#mobile").focus(function(event) {
        $("#mobile").removeClass("is-invalid");
        $("#mobile-feedback").text("");
    });

    $("#code").focus(function(event) {
        $("#code").removeClass("is-invalid");
        $("#code-feedback").text("");
    });

    var regMobile = /^1[3-9]\d{9}$/;
    var regCode = /^\d{6}$/;

    var lr = {
        removeErrorMessage: function() {
            $("#mobile").removeClass("is-invalid");
            $("#mobile-feedback").text("");
            $("#code").removeClass("is-invalid");
            $("#code-feedback").text("");
        },
        checkMobile: function() {
            if ($("#mobile").val() == "") {
                $("#mobile").addClass("is-invalid");
                $("#mobile-feedback").text("请输入手机号！");
                return false;
            }
            if (!regMobile.test($("#mobile").val())) {
                 $("#mobile").addClass("is-invalid");
                 $("#mobile-feedback").text("手机号格式不正确！");
                 return false;
            }
            return true;
        },
        checkCode: function() {
            if ($("#code").val() == "") {
                $("#code").addClass("is-invalid");
                $("#code-feedback").text("请输入验证码！");
                return false;
            }
            if (!regCode.test($("#code").val())) {
                 $("#code").addClass("is-invalid");
                 $("#code-feedback").text("验证码格式不正确！");
                 return false;
            }
            return true;
        },
        sendCode: function(type, condition, init, completed) {
            event.preventDefault();
            if (!condition()) return;
            this.removeErrorMessage();
            if (!this.checkMobile()) return;

            init();
            yiRemote.post(conf.hostUserService, conf.uriMobileVerificationCode, {
                mobile: $("#mobile").val(),
                type: type
            }, function(data) {
                var seconds = 60;
                $("#send-code").text(seconds-- + "s");
                $("#send-code").addClass("disabled");
                var timer = setInterval(function() {
                    if (seconds > 0) {
                        $("#send-code").text(seconds-- + "s");
                    } else {
                        $("#send-code").text("发送验证码");
                        $("#send-code").removeClass("disabled");
                        clearInterval(timer);
                        completed();
                    }
                }, 1000);
            }, function(status, code, message) {
                $("#mobile").addClass("is-invalid");
                $("#mobile-feedback").text(message);
                completed();
            });
        }
    };

    return lr;

});