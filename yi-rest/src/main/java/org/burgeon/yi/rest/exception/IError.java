package org.burgeon.yi.rest.exception;

/**
 * @author Sam Lu
 * @date 2022/3/12
 */
public interface IError {

    /**
     * 获取错误编码
     *
     * @return
     */
    int getCode();

    /**
     * 获取错误信息
     *
     * @return
     */
    String getMessage();

}
