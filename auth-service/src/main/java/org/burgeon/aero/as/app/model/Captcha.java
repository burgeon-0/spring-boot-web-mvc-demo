package org.burgeon.aero.as.app.model;

import lombok.Data;
import org.burgeon.aero.as.domain.enums.CaptchaType;

import javax.validation.constraints.NotNull;

/**
 * @author Sam Lu
 * @date 2021/12/11
 */
@Data
public class Captcha {

    @NotNull
    private CaptchaType type;

    @NotNull
    private String subject;

}
