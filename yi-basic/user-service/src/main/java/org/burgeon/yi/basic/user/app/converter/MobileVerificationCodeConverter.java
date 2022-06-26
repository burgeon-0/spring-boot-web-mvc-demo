package org.burgeon.yi.basic.user.app.converter;

import org.burgeon.yi.basic.user.client.dto.request.MobileVerificationCodeSendRequest;
import org.burgeon.yi.basic.user.domain.mobileverificationcode.MobileVerificationCode;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 手机验证码转换器
 *
 * @author Sam Lu
 * @date 2022/06/26
 */
@Mapper
public interface MobileVerificationCodeConverter {

    MobileVerificationCodeConverter INSTANCE = Mappers.getMapper(MobileVerificationCodeConverter.class);

    /**
     * {@link MobileVerificationCodeSendRequest} to {@link MobileVerificationCode}
     *
     * @param request
     * @return
     */
    MobileVerificationCode toMobileVerificationCode(MobileVerificationCodeSendRequest request);

}
