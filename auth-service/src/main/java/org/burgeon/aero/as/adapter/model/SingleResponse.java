package org.burgeon.aero.as.adapter.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * @author Sam Lu
 * @date 2021/12/11
 */
@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SingleResponse<T> extends Response {

    /**
     * 返回数据
     */
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
