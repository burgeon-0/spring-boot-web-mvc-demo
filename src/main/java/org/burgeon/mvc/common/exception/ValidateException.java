package org.burgeon.mvc.common.exception;

import lombok.Data;

/**
 * @author Sam Lu
 * @date 2022/2/23
 */
@Data
public class ValidateException extends RuntimeException {

    private ErrorEnum error;

    public ValidateException(ErrorEnum error) {
        super(error.getMessage());
        this.error = error;
    }

}
