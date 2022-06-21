package org.burgeon.yi.boot.definition.web;

import lombok.Data;

/**
 * Web请求，返回结果
 *
 * @author Sam Lu
 * @date 2022/06/15
 */
@Data
public class Result<T> {

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("ok");
        result.setData(data);
        return result;
    }

}
