require(["c-conf", "c-lr", "c-yi-remote", "c-lock"], function(conf, cLr, yiRemote, cLock) {

    "use strict";

    var lr = new cLr();

    $("#send-code").click(function(event) {
        lr.sendCode("REGISTER");
    });

    $("#agreeTerms").click(function(event) {
        if ($("#agreeTerms").is(":checked")) {
            $("#agreeTerms").removeClass("is-invalid");
            $("#agreeTerms-feedback").text("");
        } else {
            $("#agreeTerms").addClass("is-invalid");
            $("#agreeTerms-feedback").text("请先阅读并勾选同意《用户协议》");
        }
    });

    var lock = new cLock();
    $("#register").click(function(event) {
        event.preventDefault();
        if (!lr.checkMobile()) return;
        if (!lr.checkCode()) return;

        if (!$("#agreeTerms").is(":checked")) {
            $("#agreeTerms").addClass("is-invalid");
            $("#agreeTerms-feedback").text("请先阅读并勾选同意《用户协议》");
            return;
        }

        if (!lock.tryLock()) return;
        yiRemote.post(conf.hostUserService, conf.uriRegisterWithMobileCaptcha, {
            mobile: $("#mobile").val(),
            code: $("#code").val()
        }, function(data) {
            lock.release();
            window.location.href = data;
        }, function(status, code, message) {
            $("#code").addClass("is-invalid");
            $("#code-feedback").text(message);
            lock.release();
        });
    });

});