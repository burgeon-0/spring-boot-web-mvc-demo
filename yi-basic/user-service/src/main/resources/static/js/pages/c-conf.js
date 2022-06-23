define([], function() {

    "use strict";

    var config = {
        hostUserService: "http://localhost:8383",
        uriMobileVerificationCode: "/cgi/mobile-verification-codes",
        uriLoginMobile: "/cgi/login/mobile",
        uriRegisterMobile: "/cgi/register/mobile"
    };

    return config;

});