require(['s-config', 'lr-validator'], function(config, validator) {

    "use strict";

    $("#get-code").click(function(event) {
        event.preventDefault();
        validator.checkMobile();
    });

    $("#register").click(function(event) {
        event.preventDefault();
        validator.checkMobile();
        validator.checkCode();
    });

});