package org.burgeon.yi.boot.definition.exception;

/**
 * 异常枚举接口
 *
 * @author Sam Lu
 * @date 2022/06/21
 */
public interface ErrorEnum {

    /**
     * 获取错误码
     *
     * @return
     */
    String getCode();

    /**
     * 获取错误信息
     *
     * @return
     */
    String getMessage();

}
