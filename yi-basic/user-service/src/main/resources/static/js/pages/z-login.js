require(["c-conf", "c-lr", "c-yi-remote"], function(conf, lr, yiRemote) {

    "use strict";

    var blockSendCode = false;
    $("#send-code").click(function(event) {
        lr.sendCode("LOGIN", function() {
            return !blockSendCode;
        }, function() {
            blockSendCode = true;
        }, function() {
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
            blockLogin = false;
            window.location.href = data;
        }, function(status, code, message) {
            $("#code").addClass("is-invalid");
            $("#code-feedback").text(message);
            blockLogin = false;
        });
    });

});