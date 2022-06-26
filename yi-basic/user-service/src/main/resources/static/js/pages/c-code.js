define([], function() {

    "use strict";

    var codeMap = new Map([
        ["0101001", "验证码不存在或已过期!"],
        ["0101002", "验证码不正确!"]
    ]);

    return codeMap;

});