define([], function() {

    "use strict";

    var config = {
        hostUserService: "http://localhost:8383",
        uriLoginSendMobileCaptcha: "/cgi/login/actions/send-mobile-captcha",
        uriLoginByMobileCaptcha: "/cgi/login/mobile",
        uriRegisterSendMobileCaptcha: "/cgi/register/actions/send-mobile-captcha",
        uriRegisterByMobileCaptcha: "/cgi/register/mobile"
    };

    return config;

});