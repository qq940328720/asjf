package com.aishang.asjf.common.utils;

/**
 * Created by whb on 17-12-20.
 */
public class ConstantClassFunction {


    //银行预留手机号正则
    public static final String REG_MOBILEPHONE = "^13[\\d]{9}$|^14[5,6,7,8,9]{1}\\d{8}$|^15[^4]{1}\\d{8}$|^16[6]{1}\\d{8}$|^17[0,1,2,3,4,5,6,7,8]{1}\\d{8}$|^18[\\d]{9}$|^19[8,9]{1}\\d{8}$";

    //工作信息手机号或固定电话正则
    public static final String REG_MOBILORPHONE = "(^((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(19[0-9])|(18[0-9]))\\d{8}$)||(^0\\d{2,3}[- ]?\\d{7,8}$)";

    //固定电话正则
    public static final String STATIONARY_PHONE = "^0\\d{2,3}[- ]?\\d{7,8}$";

    //四位数字正则
    public static final String VERIFICATION_CODE = "/^\\d{4}$/";

    //身份证号正则
    public static final
    String REG_IDCERT="(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}[0-9Xx]$)";

}
