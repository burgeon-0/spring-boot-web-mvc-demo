package org.burgeon.yi.rest.exception;

import java.util.Collection;

/**
 * @author Sam Lu
 * @date 2022/2/23
 */
public class AssertX {

    public static void isTrue(boolean expression, IError error) {
        if (!expression) {
            throw new ValidateException(error);
        }
    }

    public static void isFalse(boolean expression, IError error) {
        if (expression) {
            throw new ValidateException(error);
        }
    }

    public static void isNull(Object object, IError error) {
        if (object != null) {
            throw new ValidateException(error);
        }
    }

    public static void notNull(Object object, IError error) {
        if (object == null) {
            throw new ValidateException(error);
        }
    }

    public static void isBlank(String str, IError error) {
        if (str != null && !"".equals(str)) {
            throw new ValidateException(error);
        }
    }

    public static void notBlank(String str, IError error) {
        if (str == null || "".equals(str)) {
            throw new ValidateException(error);
        }
    }

    public static void isEmpty(Collection collection, IError error) {
        if (collection != null && !collection.isEmpty()) {
            throw new ValidateException(error);
        }
    }

    public static void notEmpty(Collection collection, IError error) {
        if (collection == null || collection.isEmpty()) {
            throw new ValidateException(error);
        }
    }

}
