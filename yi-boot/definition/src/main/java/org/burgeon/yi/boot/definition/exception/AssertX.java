package org.burgeon.yi.boot.definition.exception;

import java.util.Objects;

/**
 * 断言工具类
 *
 * @author Sam Lu
 * @date 2022/06/25
 */
public class AssertX {

    /**
     * 断言为空
     *
     * @param object
     * @param error
     */
    public static void isNull(Object object, ErrorEnum error) throws ValidationException {
        if (!Objects.isNull(object)) {
            throw new ValidationException(error);
        }
    }

    /**
     * 断言不为空
     *
     * @param object
     * @param error
     */
    public static void isNotNull(Object object, ErrorEnum error) throws ValidationException {
        if (Objects.isNull(object)) {
            throw new ValidationException(error);
        }
    }

    /**
     * 断言为真
     *
     * @param expression
     * @param error
     */
    public static void isTrue(boolean expression, ErrorEnum error) throws ValidationException {
        if (!expression) {
            throw new ValidationException(error);
        }
    }

    /**
     * 断言为假
     *
     * @param expression
     * @param error
     */
    public static void isFalse(boolean expression, ErrorEnum error) throws ValidationException {
        if (expression) {
            throw new ValidationException(error);
        }
    }

}
