require(["c-conf", "c-lr", "c-yi-remote"], function(conf, lr, yiRemote) {

    "use strict";

    var blockSendCode = false;

    $("#send-code").click(function(event) {
        event.preventDefault();
        if (blockSendCode) return;
        lr.removeErrorMessage();
        if (!lr.checkMobile()) return;

        blockSendCode = true;
        yiRemote.post(conf.hostUserService, conf.uriMobileVerificationCode, {
            mobile: $("#mobile").val(),
            type: "LOGIN"
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

    var blockLogin = false;

    $("#login").click(function(event) {
        event.preventDefault();
        if (!lr.checkMobile()) return;
        if (!lr.checkCode()) return;

        blockLogin = true;
        yiRemote.post(conf.hostUserService, conf.uriLoginMobile, {
            mobile: $("#mobile").val(),
            code: $("#code").val()
        }, function(data) {
            console.log(data);
            blockLogin = false;
        }, function(status, code, message) {
            $("#code").addClass("is-invalid");
            $("#code-feedback").text(message);
            blockLogin = false;
        });
    });

});