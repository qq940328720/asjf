package com.aishang.asjf.common.sms;

import com.aishang.asjf.common.UniqueCodeGenerator;
import com.aishang.asjf.common.enums.SmsCodeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class SmsHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(SmsHelper.class);

    private Long expires = 5l;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    /**
     * 发送验证码
     *
     * @param smsCodeType 验证码类型
     * @param phone       手机号
     * @return 验证码
     * @throws Exception
     */
    public String generateCode(SmsCodeType smsCodeType, String phone) throws Exception {
        LOGGER.info("开始生成短信验证码");
        String code = UniqueCodeGenerator.getRandomCode();
        LOGGER.debug("验证码是：{}", code);
        stringRedisTemplate.opsForValue().set(getKey(smsCodeType, phone), code, expires, TimeUnit.MINUTES);
        LOGGER.info("已放入redis");
        return code;
    }

    /**
     * 获取验证码
     *
     * @param smsCodeType 验证码类型
     * @param phone       手机号
     * @return 验证码
     * @throws Exception
     */
    public String getSmsCode(SmsCodeType smsCodeType, String phone) throws Exception {
        return stringRedisTemplate.opsForValue().get(getKey(smsCodeType, phone));
    }

    /**
     * 删除验证码
     *
     * @param smsCodeType 验证码类型
     * @param phone       手机号
     * @throws Exception
     */
    public void delete(SmsCodeType smsCodeType, String phone) throws Exception {
        stringRedisTemplate.delete(getKey(smsCodeType, phone));
    }

    /**
     * 生成组合key
     *
     * @param smsCodeType 验证码类型
     * @param phone       手机号
     * @return key
     */
    private String getKey(SmsCodeType smsCodeType, String phone) {
        return String.format("%s_%s", smsCodeType.name(), phone);
    }
}
