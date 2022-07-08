define([], function() {

    "use strict";

    (function() {
    	$("#username").focus(function(_event) {
            $("#username").removeClass("is-invalid");
            $("#username-feedback").text("");
        });
        $("#password").focus(function(_event) {
            $("#password").removeClass("is-invalid");
            $("#password-feedback").text("");
        });
    }());

    return function() {
        this.checkUsername = function() {
            if ($("#username").val() == "") {
                $("#username").addClass("is-invalid");
                $("#username-feedback").text("请输入账号！");
                return false;
            }
            return true;
        };
        this.checkPassword = function() {
            if ($("#password").val() == "") {
                $("#password").addClass("is-invalid");
                $("#password-feedback").text("请输入密码！");
                return false;
            }
            return true;
        };
    };

});