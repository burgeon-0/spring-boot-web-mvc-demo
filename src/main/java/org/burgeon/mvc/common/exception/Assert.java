package org.burgeon.mvc.common.exception;

import java.util.Collection;

/**
 * @author Sam Lu
 * @date 2022/2/23
 */
public class Assert {

    public static void isTrue(boolean expression, ErrorEnum error) {
        if (!expression) {
            throw new ValidateException(error);
        }
    }

    public static void isFalse(boolean expression, ErrorEnum error) {
        if (expression) {
            throw new ValidateException(error);
        }
    }

    public static void isNull(Object object, ErrorEnum error) {
        if (object != null) {
            throw new ValidateException(error);
        }
    }

    public static void notNull(Object object, ErrorEnum error) {
        if (object == null) {
            throw new ValidateException(error);
        }
    }

    public static void isBlank(String str, ErrorEnum error) {
        if (str != null && !"".equals(str)) {
            throw new ValidateException(error);
        }
    }

    public static void notBlank(String str, ErrorEnum error) {
        if (str == null || "".equals(str)) {
            throw new ValidateException(error);
        }
    }

    public static void isEmpty(Collection collection, ErrorEnum error) {
        if (collection != null && !collection.isEmpty()) {
            throw new ValidateException(error);
        }
    }

    public static void notEmpty(Collection collection, ErrorEnum error) {
        if (collection == null || collection.isEmpty()) {
            throw new ValidateException(error);
        }
    }

}
