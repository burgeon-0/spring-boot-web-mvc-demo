package org.burgeon.aero.as.infra.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Sam Lu
 * @date 2021/11/30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RestException extends RuntimeException {

    private ErrorCode errorCode;

    public RestException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

}
