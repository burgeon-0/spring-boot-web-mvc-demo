define([], function() {

    "use strict";

    return {
        hostUserService: "http://localhost:8383",
        uriLoginSendMobileCaptcha: "/cgi/login/actions/send-mobile-captcha",
        uriLoginWithMobileCaptcha: "/cgi/login/mobile-captcha",
        uriRegisterSendMobileCaptcha: "/cgi/register/actions/send-mobile-captcha",
        uriRegisterWithMobileCaptcha: "/cgi/register/mobile-captcha"
    };

});