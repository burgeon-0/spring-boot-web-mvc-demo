define(["c-remote", "c-code"], function(remote, codeMap) {

    "use strict";

    var yiRemote = {
        post: function(host, uri, body, success, error) {
            var yiSuccess = function(response) {
                console.log("success => ");
                console.log("code: " + response.code);
                console.log("message: " + response.message);
                console.log("data: " + response.data);
                success(response.data);
            };
            var yiError = function(xhr, ajaxOptions, thrownError) {
                console.log("error => ");
                console.log("readyState: " + xhr.readyState);
                console.log("status: " + xhr.status);
                console.log("statusText: " + xhr.statusText);
                console.log("responseText: " + xhr.responseText);
                console.log("ajaxOptions: " + ajaxOptions);
                console.log("thrownError: " + thrownError);

                var code = ("" + xhr.responseJSON.code).substring(3, 10);
                var message = codeMap.get(code);
                message != undefined ? message : xhr.status < 500 ? "未知异常！" : "服务器错误！";
                error(xhr.status, code, message);
            };
            $.ajax({
                method: "POST",
                url: host + uri,
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(body),
                success: yiSuccess,
                error: yiError
            });
        }
    };

    return yiRemote;

});