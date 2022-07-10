define(["c-remote", "c-code"], function(remote, codeMap) {

    "use strict";

    return {
        post: function(host, uri, body, success, error) {
            let yiSuccess = function(response) {
                console.log("success => ");
                console.log("code: " + response.code);
                console.log("message: " + response.message);
                console.log("data: " + response.data);

                success(response.data);
            };

            let yiError = function(xhr, ajaxOptions, thrownError) {
                console.log("error => ");
                console.log("readyState: " + xhr.readyState);
                console.log("status: " + xhr.status);
                console.log("statusText: " + xhr.statusText);
                console.log("responseText: " + xhr.responseText);
                console.log("ajaxOptions: " + ajaxOptions);
                console.log("thrownError: " + thrownError);

                let code = ("" + xhr.responseJSON.code).substring(3, 10);
                let message = codeMap.get(code);
                let defaultMessage = xhr.status < 500 ? "未知异常！" : "服务器错误！";
                message = message != undefined ? message : defaultMessage;
                error(xhr.status, code, message);
            };

            remote.post(host, uri, body, yiSuccess, yiError);
        }
    };

});