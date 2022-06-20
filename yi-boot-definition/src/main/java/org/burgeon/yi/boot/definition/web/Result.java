package org.burgeon.yi.boot.definition.web;

/**
 * @author Sam Lu
 * @date 2022/06/15
 */
public class Result<T> {

    /**
     * 返回错误码
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

}
