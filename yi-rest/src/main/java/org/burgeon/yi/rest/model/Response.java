package org.burgeon.yi.rest.model;

import org.springframework.http.HttpStatus;

/**
 * @author Sam Lu
 * @date 2022/2/23
 */
public class Response {

    private int code;

    private String message;

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Response ok() {
        return new Response(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    public static Response created() {
        return new Response(HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase());
    }

}
