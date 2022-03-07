package org.burgeon.mvc.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author Sam Lu
 * @date 2022/2/23
 */
@Data
@AllArgsConstructor
public class Response {

    private int code;

    private String message;

    public static Response ok() {
        return new Response(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    public static Response created() {
        return new Response(HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase());
    }

}
