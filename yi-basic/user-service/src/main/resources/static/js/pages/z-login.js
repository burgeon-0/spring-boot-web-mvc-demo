require(["c-conf", "c-lr", "c-remote"], function(conf, lr, remote) {

    "use strict";

    $("#get-code").click(function(event) {
        event.preventDefault();
        if (!lr.checkMobile()) return;

        remote.post(conf.hostUserService, conf.uriMobileVerificationCode, {
            mobile: $("#mobile").val(),
            type: "LOGIN"
        }, function(data) {
            console.log(data);
        });
    });

    $("#login").click(function(event) {
        event.preventDefault();
        if (!lr.checkMobile()) return;
        if (!lr.checkCode()) return;

        remote.post(conf.hostUserService, conf.uriLoginMobile, {
            mobile: $("#mobile").val(),
            code: $("#code").val()
        }, function(data) {
            console.log(data);
        });
    });

});