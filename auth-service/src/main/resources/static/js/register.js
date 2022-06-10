(function ($) {

    "use strict";

    var mobileReg = /^1[3-9]\d{9}$/;
    var passwordReg = /^.*(?=.{8,16})(?=.*\d)(?=.*[A-Z|a-z]+)(?=.*[!@#$%^&*?\(\)]).*$/;

    var showGetCodeErrorAndPreventDefault = function showErrorAndPreventDefault(event, errMsg) {
        $(".register-form .get-code-error-message > span").html(errMsg);
        $(".register-form .get-code-error-message").show();
        event.preventDefault();
    };

    var showErrorAndPreventDefault = function showErrorAndPreventDefault(event, errMsg) {
        $(".register-form .error-message > span").html(errMsg);
        $(".register-form .error-message").show();
        event.preventDefault();
    };

    var enableGetCodeButton = function enableGetCodeButton() {
        $("#get-code").text("获取验证码");
        $("#get-code").removeClass("disabled");
        $("#get-code").on("click", getCodeButtonOnClick);
        $("#get-code").off("click", getCodeButtonOffClick);
    };

    var disableGetCodeButton = function disableGetCodeButton(time) {
        $("#get-code").text(time + "s");
        $("#get-code").addClass("disabled");
        $("#get-code").on("click", getCodeButtonOffClick);
        $("#get-code").off("click", getCodeButtonOnClick);
    };

    var getCodeButtonOnClick = function getCodeButtonOnClick(event) {
        if ($("#mobile").val() === "") {
            showGetCodeErrorAndPreventDefault(event, "请输入手机号码");
            return;
        }
        if (!mobileReg.test($("#mobile").val())) {
            showGetCodeErrorAndPreventDefault(event, "手机号码不正确");
            return;
        }
        $(".register-form .get-code-error-message").hide();

        $.ajax({
            type: "POST",
            url: "/cgi/captcha",
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            data: JSON.stringify({
                type: 0,
                subject: $("#mobile").val()
            }),
            success: function (result, status, xhr) {
                var time = 60;
                disableGetCodeButton(time);
                var timer = setInterval(function () {
                    if (--time > 0) {
                        disableGetCodeButton(time);
                    } else {
                        enableGetCodeButton();
                        clearInterval(timer);
                    }
                }, 1000);
            },
            error: function (xhr, status, error) {
                showGetCodeErrorAndPreventDefault(event, "发送验证码失败");
            }
        });

        event.preventDefault();
    };

    var getCodeButtonOffClick = function getCodeButtonOffClick(event) {
        event.preventDefault();
    };

    $("#mobile, #code, #password, #rePassword").focus(function () {
        $(".register-form .get-code-error-message").hide();
        $(".register-form .error-message").hide();
    });
    enableGetCodeButton();

    $("form").submit(function (event) {
        if ($("#mobile").val() === "") {
            showErrorAndPreventDefault(event, "请输入手机号码");
            return;
        }
        if (!mobileReg.test($("#mobile").val())) {
            showErrorAndPreventDefault(event, "手机号码不正确");
            return;
        }
        if ($("#code").val() === "") {
            showErrorAndPreventDefault(event, "请输入验证码");
            return;
        }
        if ($("#password").val() === "") {
            showErrorAndPreventDefault(event, "请输入密码");
            return;
        }
        if (!passwordReg.test($("#password").val())) {
            showErrorAndPreventDefault(event, "密码长度8-16位，且至少包含1个数字、1个字母和1个特殊字符");
            return;
        }
        if ($("#rePassword").val() === "") {
            showErrorAndPreventDefault(event, "请输入确认密码");
            return;
        }
        if ($("#password").val() != $("#rePassword").val()) {
            showErrorAndPreventDefault(event, "两次输入密码不一致");
            return;
        }

        $("#password").val(sha256($("#password").val()));
        $("#rePassword").val(sha256($("#rePassword").val()));
    });

})(jQuery);
