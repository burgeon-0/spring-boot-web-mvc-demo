define([], function() {

    "use strict";

    return function() {
        this.locked = false;
        this.tryLock = function() {
            if (!this.locked) {
                this.locked = true;
                return true;
            }
            return false;
        };
        this.release = function() {
            this.locked = false;
        };
    };

});