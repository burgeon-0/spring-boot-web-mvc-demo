(function($) {

    "use strict";

    $("#get-code").click(function(event) {
        event.preventDefault();
        $.formValidator.checkMobile();

        console.log($.webConfig.hostUserService);
        console.log($.webConfig.uriMobileVerificationCode);
    });

    $("#login").click(function(event) {
        event.preventDefault();
        $.formValidator.checkMobile();
        $.formValidator.checkCode();
    });

})(jQuery);