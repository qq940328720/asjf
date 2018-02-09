package com.aishang.asjf.common.enums;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

/**
 * Created by neeke on 17-9-7.
 */
@JsonSerialize(using = ErrorCode.ErrorCodeJsonSerializer.class)
public enum ErrorCode {

    OK("100", "操作成功"),
    ACCESS_DENIED("101", "访问被拒绝"),
    NO_HANDLER_FOUND("102", "该页面不存在"),
    EXPIRED_JWT_EXCEPTION("103", "accessToken已过期"),
    EXCEPTION("104", "异常"),
    HANDLE_HTTP_MEDIA_TYPE_NOT_ACCEPTABLE("105", "不接受的媒体类型"),
    HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION("106", "不支持的请求方法"),
    AUTHENTICATION_EXCEPTION("107", "身份认证异常"),
    MISSING_CLAIM_EXCEPTION("108", "缺失CLAIM"),
    SMS_SEND_FAILURE("109", "短信发送失败"),
    TWO_PASSWORD_NOT_EQUALS("110", "两次密码不匹配"),
    BAD_CREDENTIALS_EXCEPTION("111", "账号或密码错误"),
    USER_EXIST("112", "账号已被注册,请尝试找回密码"),
    LOCKED_EXCEPTION("113", "账号已被锁定"),
    METHOD_ARGUMENT_NOT_VALID_EXCEPTION("114", "参数校验不通过"),
    QR_CODE_INVALID("115", "二维码失效"),
    NO_DATA("116", "查无数据"),
    FAILURE("117", "操作失败"),
    UNBOUNDU_STORES("118", "该业务员未绑定门店"),
    ILLEGAL_ARGUMENT_EXCEPTION("119", "非法参数"),
    COMMODITY_STATE_EXCEPTION("120", "商品已下架"),
    STORE_STATE_EXCEPTION("121", "门店已关闭"),
    PRODUCT_STATE_EXCEPTION("122", "产品已禁用"),
    NOT_IN_STORE("123", "该业务员不在门店范围内"),
    FAILURE_OF_BANK_CARD_VERIFICATION("124", "银行卡验证失败"),
    DO_NOT_SUPPORT_CREDIT_CARDS("125", "信用卡暂不支持"),
    DO_NOT_SUPPORT_THE_BANK("126", "暂不支持该银行"),
    SMS_CODE_INVALID("127", "短信验证码无效"),
    USERNAME_OR_PASSWORD_ERROR("128", "用户名或密码错误"),
    USER_INFO_INCOMPLETE("129", "用户个人信息不完整"),
    USER_IDCERT_OUT_VALIDATE("130", "您的身份证即将到期"),
    USER_THREE__ESSENTIAL_NO_PASS("131", "此卡必须为本人银行卡"),
    USER_SAVE_BANK_FAILED("132", "保存银行卡失败"),
    USER_UPDATE_COMPETION_FAILED("133", "修改用户资料完善度失败"),
    USER__BANK_ILLEGAL("134", "请输入合法的银行卡号码"),
    USER__IDCERT_NAME_UNMATCH("135", "身份证与名字不符"),
    UNFINISHED_ORDERS("136", "您有同类型订单未结清，结清后才可再次申请哦～"),
    USER_GET_CUSTMERID_FAILURE("137", "获得CustomerId失败"),
    PUSH_DATA_FAILURE("138", "推送数据失败"),
    SAVE_CUSTMERID_FAILURE("139", "保存CustomerId失败"),
    GET_PRODUCT_IS_SUPPORT_AS_FAILURE("140", "查询产品失败"),
    FIRST_LINKER_CANT_EMPTY("141", "第一联系人的省市区不能为空"),
    FIRST_LINKER_INFO_CANT_EMPTY("142", "第一联系人的相关信息不能为空"),
    FIRST_LINKER_ADDRESS_DETAILED_CANT_EMPTY("143", "第一联系人的详细住址不能为空"),
    SECOND_LINKER_INFO_CANT_EMPTY("144", "第二联系人不能为空"),
    THIRD_LINKER_INFO_CANT_EMPTY("145", "第三联系人不能为空"),
    GET_SIGNATRUE_FAILURE("146", "获取电子签约地址失败"),
    USER_CREDIT_IMAGE_INCOMPLETE("147", "用户信审照片不全"),
    REFUSAL_RECORD("148", "您3个月内有拒单记录，请%s天后再重试申请哦～"),
    NO_PRODUCT_INFO("149", "查无该产品信息"),
    IDCERT_WILL_OVERDUE("150", "您的身份证即将过期"),
    IDCERT_OVERDUED("151", "您的身份证已经过期"),
    USET_INCOME_NOT_LITTLE_TO_ZERO("152", "收入不能小于0"),
    GET_PRODUCT_SIGN_INFO_FAILURE("153", "查询产品签约信息失败"),
    SIGN_FAILURE("154", "签约失败"),
    NOT_BELONG_USERSELF_ORDER("155", "该订单号非登录本人的订单");

    private String code;
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static class ErrorCodeJsonSerializer extends JsonSerializer<ErrorCode> {

        @Override
        public void serialize(ErrorCode errorCode, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (null != errorCode) {
                jsonGenerator.writeStartObject();
                jsonGenerator.writeFieldName("code");
                jsonGenerator.writeObject(errorCode.code);
                jsonGenerator.writeFieldName("message");
                jsonGenerator.writeObject(errorCode.message);
                jsonGenerator.writeEndObject();
            } else {
                jsonGenerator.writeNull();
            }
        }
    }
}
