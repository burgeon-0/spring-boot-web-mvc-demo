(function ($) {

    "use strict";

    $("#get-code").click(function(event) {
        event.preventDefault();
        $.formValidator.checkMobile();
    });

    $("#register").click(function(event) {
        event.preventDefault();
        $.formValidator.checkMobile();
        $.formValidator.checkCode();
    });

})(jQuery);