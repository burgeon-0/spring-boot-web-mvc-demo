require(["c-conf", "c-lr"], function(conf, lr) {

    "use strict";

    $("#get-code").click(function(event) {
        event.preventDefault();
        if (!lr.checkMobile()) return;

        var data = {
            mobile: $("#mobile").val(),
            verificationCodeType: "LOGIN"
        };
        $.ajax({
            method: "POST",
            url: conf.hostUserService + conf.uriMobileVerificationCode,
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            success: function(data) {
                console.log(data);
            }
        });
    });

    $("#login").click(function(event) {
        event.preventDefault();
        if (!lr.checkMobile()) return;
        if (!lr.checkCode()) return;
    });

});