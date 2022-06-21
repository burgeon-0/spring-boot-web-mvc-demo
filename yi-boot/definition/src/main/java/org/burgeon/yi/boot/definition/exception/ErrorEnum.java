package org.burgeon.yi.boot.definition.exception;

/**
 * @author Sam Lu
 * @date 2022/06/21
 */
public interface ErrorEnum {

    /**
     * 获取错误码
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
