(function($) {

    "use strict";

    var regMobile = /^1[3-9]\d{9}$/;
    var regCode = /^\d{6}$/;

    jQuery.extend({
        formValidator: {
            checkMobile: function() {
                if ($("#mobile").val() == "") {
                    $("#mobile").addClass("is-invalid");
                    $("#mobile-feedback").text("请输入手机号！");
                    return;
                }
                if (!regMobile.test($("#mobile").val())) {
                     $("#mobile").addClass("is-invalid");
                     $("#mobile-feedback").text("手机号格式不正确！");
                }
            },
            checkCode: function() {
                if ($("#code").val() == "") {
                    $("#code").addClass("is-invalid");
                    $("#code-feedback").text("请输入验证码！");
                    return;
                }
                if (!regCode.test($("#code").val())) {
                     $("#code").addClass("is-invalid");
                     $("#code-feedback").text("验证码格式不正确！");
                }
            }
        }
    });

    $("#mobile").focus(function(event) {
        $("#mobile").removeClass("is-invalid");
        $("#mobile-feedback").text("");
    });

    $("#code").focus(function(event) {
        $("#code").removeClass("is-invalid");
        $("#code-feedback").text("");
    });

})(jQuery);