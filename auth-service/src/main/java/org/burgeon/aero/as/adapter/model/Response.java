package org.burgeon.aero.as.adapter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author Sam Lu
 * @date 2021/12/11
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Response implements Serializable {

    /**
     * 状态编码
     */
    private long code;
    /**
     * 状态信息
     */
    private String message;

    public static Response ok() {
        return new Response(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    public static Response created() {
        return new Response(HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase());
    }

}
