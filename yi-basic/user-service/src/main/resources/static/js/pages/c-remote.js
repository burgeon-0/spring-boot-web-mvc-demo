define([], function() {

    "use strict";

    var remote = {
        post: function(host, uri, data, success, error) {
            if (error == undefined) {
                error = function(xhr, ajaxOptions, thrownError) {
                    console.log("error => ");
                    console.log("readyState: " + xhr.readyState);
                    console.log("status: " + xhr.status);
                    console.log("statusText: " + xhr.statusText);
                    console.log("responseText: " + xhr.responseText);
                    console.log("ajaxOptions: " + ajaxOptions);
                    console.log("thrownError: " + thrownError);
                };
            }
            $.ajax({
                method: "POST",
                url: host + uri,
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(data),
                success: success,
                error: error
            });
        }
    };

    return remote;

});