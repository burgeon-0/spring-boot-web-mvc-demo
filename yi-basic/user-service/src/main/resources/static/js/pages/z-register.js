require(["c-conf", "c-lr", "c-yi-remote"], function(conf, lr, yiRemote) {

    "use strict";

    $("#agreeTerms").click(function(event) {
        if ($("#agreeTerms").is(":checked")) {
            $("#agreeTerms").removeClass("is-invalid");
            $("#agreeTerms-feedback").text("");
        } else {
            $("#agreeTerms").addClass("is-invalid");
            $("#agreeTerms-feedback").text("请先阅读并勾选同意《用户协议》");
        }
    });

    var blockSendCode = false;

    $("#send-code").click(function(event) {
        event.preventDefault();
        if (blockSendCode) return;
        lr.removeErrorMessage();
        if (!lr.checkMobile()) return;

        blockSendCode = true;
        yiRemote.post(conf.hostUserService, conf.uriMobileVerificationCode, {
            mobile: $("#mobile").val(),
            type: "REGISTER"
        }, function(data) {
            console.log(data);
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
                    blockSendCode = false;
                }
            }, 1000);
        }, function(status, code, message) {
            $("#mobile").addClass("is-invalid");
            $("#mobile-feedback").text(message);
            blockSendCode = false;
        });
    });

    var blockRegister = false;

    $("#register").click(function(event) {
        event.preventDefault();
        if (!lr.checkMobile()) return;
        if (!lr.checkCode()) return;

        if (!$("#agreeTerms").is(":checked")) {
            $("#agreeTerms").addClass("is-invalid");
            $("#agreeTerms-feedback").text("请先阅读并勾选同意《用户协议》");
            return;
        }

        blockRegister = true;
        yiRemote.post(conf.hostUserService, conf.uriRegisterMobile, {
            mobile: $("#mobile").val(),
            code: $("#code").val()
        }, function(data) {
            blockRegister = false;
            window.location.href = data;
        }, function(status, code, message) {
            $("#code").addClass("is-invalid");
            $("#code-feedback").text(message);
            blockRegister = false;
        });
    });

});