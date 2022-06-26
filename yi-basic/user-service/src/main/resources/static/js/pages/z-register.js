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
        lr.sendCode("REGISTER", function() {
            return !blockSendCode;
        }, function() {
            blockSendCode = true;
        }, function() {
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