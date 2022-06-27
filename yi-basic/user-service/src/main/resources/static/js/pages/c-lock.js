define([], function() {

    "use strict";

    var lock = function() {
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

    return lock;

});