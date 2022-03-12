package org.burgeon.yi.rest.exception;

/**
 * @author Sam Lu
 * @date 2022/2/23
 */
public class ValidateException extends RuntimeException {

    private IError error;

    public ValidateException(IError error) {
        super(error.getMessage());
        this.error = error;
    }

    public IError getError() {
        return error;
    }

    public void setError(IError error) {
        this.error = error;
    }

}
