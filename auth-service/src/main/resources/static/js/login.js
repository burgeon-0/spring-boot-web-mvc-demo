(function ($) {

    "use strict";

    var getUrlParameter = function getUrlParameter(sParam) {
        var sPageURL = decodeURIComponent(window.location.search.substring(1)),
            sURLVariables = sPageURL.split("&"),
            sParameterName,
            i;

        for (i = 0; i < sURLVariables.length; i++) {
            sParameterName = sURLVariables[i].split("=");
            if (sParameterName[0] === sParam) {
                return sParameterName[1] === undefined ? true : sParameterName[1];
            }
        }
    };

    var showErrorAndPreventDefault = function showErrorAndPreventDefault(event, errMsg) {
        $(".login-form .error-message > span").html(errMsg);
        $(".login-form .error-message").show();
        event.preventDefault();
    };

    var error = getUrlParameter("error");
    var reloaded = performance.getEntriesByType("navigation")[0].type == "reload";
    if (error && !reloaded) {
        $(".login-form .error-message > span").html("账号或密码错误");
        $(".login-form .error-message").show();
    }

    $("#username, #password").focus(function () {
        $(".login-form .error-message").hide();
    });

    $("form").submit(function (event) {
        if ($("#username").val() === "") {
            showErrorAndPreventDefault(event, "请输入账号");
            return;
        }
        if ($("#password").val() === "") {
            showErrorAndPreventDefault(event, "请输入密码");
            return;
        }

        $("#password").val(sha256($("#password").val()));
    });

})(jQuery);
