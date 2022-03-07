package org.burgeon.mvc.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * @author Sam Lu
 * @date 2022/2/23
 */
@Getter
@Setter
@ToString
public class SingleResponse<T> extends Response {

    private T data;

    public SingleResponse(int code, String message) {
        super(code, message);
    }

    public static SingleResponse ok(Object data) {
        SingleResponse response = new SingleResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        response.setData(data);
        return response;
    }

    public static SingleResponse created(Object data) {
        SingleResponse response = new SingleResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase());
        response.setData(data);
        return response;
    }

}
