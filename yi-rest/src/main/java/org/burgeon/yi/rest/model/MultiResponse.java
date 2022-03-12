package org.burgeon.yi.rest.model;

import org.springframework.http.HttpStatus;

import java.util.Collection;

/**
 * @author Sam Lu
 * @date 2022/2/23
 */
public class MultiResponse<T> extends Response {

    private Collection<T> data;

    public MultiResponse(int code, String message) {
        super(code, message);
    }

    public Collection<T> getData() {
        return data;
    }

    public void setData(Collection<T> data) {
        this.data = data;
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
