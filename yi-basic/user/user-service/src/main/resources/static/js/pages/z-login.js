require(["c-conf", "c-lock", "c-login-basic", "c-yi-remote"], function(conf, cLock, cLb, yiRemote) {

    "use strict";

    let lb = new cLb();
    let lock = new cLock();

    $("#login").click(function(event) {
        event.preventDefault();
        if (!lb.checkUsername()) return;
        if (!lb.checkPassword()) return;

        if (!lock.tryLock()) return;
        yiRemote.post(conf.hostUserService, conf.uriLogin, {
            username: $("#username").val(),
            password: $("#password").val()
        }, function(data) {
            lock.release();
            window.location.href = data;
        }, function(_status, _code, message) {
            $("#password").addClass("is-invalid");
            $("#password-feedback").text(message);
            lock.release();
        });
    });

});