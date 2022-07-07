require(["c-conf", "c-lr", "c-yi-remote", "c-lock"], function(conf, cLr, yiRemote, cLock) {

    "use strict";

    var lr = new cLr();

    $("#send-code").click(function(event) {
        lr.sendCode(event, "LOGIN");
    });

    var lock = new cLock();
    $("#login").click(function(event) {
        event.preventDefault();
        if (!lr.checkMobile()) return;
        if (!lr.checkCode()) return;

        if (!lock.tryLock()) return;
        yiRemote.post(conf.hostUserService, conf.uriLoginWithMobileCaptcha, {
            mobile: $("#mobile").val(),
            code: $("#code").val()
        }, function(data) {
            lock.release();
            window.location.href = data;
        }, function(_status, _code, message) {
            $("#code").addClass("is-invalid");
            $("#code-feedback").text(message);
            lock.release();
        });
    });

});