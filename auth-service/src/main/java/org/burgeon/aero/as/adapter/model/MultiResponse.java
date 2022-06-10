package org.burgeon.aero.as.adapter.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.Collection;

/**
 * @author Sam Lu
 * @date 2021/12/11
 */
@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MultiResponse<T> extends Response {

    /**
     * 返回数据
     */
    private Collection<T> data;

    public MultiResponse(int code, String message) {
        super(code, message);
    }

    public static MultiResponse ok(Collection data) {
        MultiResponse response = new MultiResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        response.setData(data);
        return response;
    }

    public static MultiResponse created(Collection data) {
        MultiResponse response = new MultiResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase());
        response.setData(data);
        return response;
    }

}
