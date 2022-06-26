define([], function() {

    "use strict";

    $(function() {
        $("#send-code").width($("#send-code").width());
    });

    $("#mobile").focus(function(event) {
        $("#mobile").removeClass("is-invalid");
        $("#mobile-feedback").text("");
    });

    $("#code").focus(function(event) {
        $("#code").removeClass("is-invalid");
        $("#code-feedback").text("");
    });

    var regMobile = /^1[3-9]\d{9}$/;
    var regCode = /^\d{6}$/;

    var lr = {
        removeErrorMessage: function() {
            $("#mobile").removeClass("is-invalid");
            $("#mobile-feedback").text("");
            $("#code").removeClass("is-invalid");
            $("#code-feedback").text("");
        },
        checkMobile: function() {
            if ($("#mobile").val() == "") {
                $("#mobile").addClass("is-invalid");
                $("#mobile-feedback").text("请输入手机号！");
                return false;
            }
            if (!regMobile.test($("#mobile").val())) {
                 $("#mobile").addClass("is-invalid");
                 $("#mobile-feedback").text("手机号格式不正确！");
                 return false;
            }
            return true;
        },
        checkCode: function() {
            if ($("#code").val() == "") {
                $("#code").addClass("is-invalid");
                $("#code-feedback").text("请输入验证码！");
                return false;
            }
            if (!regCode.test($("#code").val())) {
                 $("#code").addClass("is-invalid");
                 $("#code-feedback").text("验证码格式不正确！");
                 return false;
            }
            return true;
        }
    };

    return lr;

});