package org.burgeon.yi.boot.definition.rest;

import lombok.Data;
import org.burgeon.yi.boot.definition.exception.ErrorEnum;
import org.burgeon.yi.boot.definition.exception.ValidationException;

/**
 * Web请求，返回结果
 *
 * @author Sam Lu
 * @date 2022/06/15
 */
@Data
public class Response<T> {

    /**
     * 返回码
     */
    private long code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    public static <T> Response<T> success() {
        Response<T> response = new Response<>();
        response.setCode(200);
        response.setMessage("ok");
        return response;
    }

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setCode(200);
        response.setMessage("ok");
        response.setData(data);
        return response;
    }

    public static <T> Response<T> failure(int httpStatus, ErrorEnum error) {
        Response<T> response = new Response<>();
        response.setCode(Long.parseLong(httpStatus + error.getCode()));
        response.setMessage(error.getMessage());
        return response;
    }

    public static <T> Response<T> failure(int httpStatus, ValidationException ex) {
        Response<T> response = new Response<>();
        response.setCode(Long.parseLong(httpStatus + ex.getCode()));
        response.setMessage(ex.getMessage());
        return response;
    }

    @Override
    public String toString() {
        return "{\"code\": " + code + ", \"message:\" \"" + message + "\"}";
    }

}
