package org.burgeon.aero.as.adapter.model;

import lombok.Data;
import org.burgeon.aero.as.domain.enums.CaptchaType;

import javax.validation.constraints.NotNull;

/**
 * @author Sam Lu
 * @date 2021/12/9
 */
@Data
public class SendCaptchaForm {

    @NotNull
    private CaptchaType type;

    @NotNull
    private String subject;

}
