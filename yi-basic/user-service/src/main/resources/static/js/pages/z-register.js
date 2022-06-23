require(["c-conf", "c-lr"], function(conf, lr) {

    "use strict";

    $("#get-code").click(function(event) {
        event.preventDefault();
        if (!lr.checkMobile()) return;
    });

    $("#register").click(function(event) {
        event.preventDefault();
        if (!lr.checkMobile()) return;
        if (!lr.checkCode()) return;
    });

});