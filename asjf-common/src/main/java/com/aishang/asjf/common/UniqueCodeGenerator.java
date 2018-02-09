package com.aishang.asjf.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 唯一编号生成器
 */
public class UniqueCodeGenerator {

    //应用前缀
    private static final String APP_PREFIX = "APP";
    //客户编号前缀
    private static final String CUSTOMER_PREFIX = "CUST";
    //员工编号前缀
    private static final String EMPLOYEE_PREFIX = "EMPL";
    //时间格式化
    private static final String TIME_FORMAT = "yyyyMMddHHmmssSSS";

    /**
     * 生成子应用系统编号
     *
     * @return
     */
    public static String generateAppCode() {
        StringBuffer sb = new StringBuffer(APP_PREFIX);
        sb.append(formatDate());
        return sb.toString();
    }

    /**
     * 生成客户编号
     *
     * @return
     */
    public static String generateCustCode() {
        StringBuffer sb = new StringBuffer(CUSTOMER_PREFIX);
        sb.append(formatDate());
        sb.append(getRandomString());
        return sb.toString();
    }

    /**
     * 生成员工编号
     *
     * @return
     */
    public static String generateEmplCode() {
        StringBuffer sb = new StringBuffer(EMPLOYEE_PREFIX);
        sb.append(formatDate());
        sb.append(getRandomString());
        return sb.toString();
    }

    /**
     * 格式化时间
     *
     * @return
     */
    private static String formatDate() {
        return new SimpleDateFormat(TIME_FORMAT).format(new Date());
    }

    /**
     * 格式化随机数（00）
     *
     * @return
     */
    private static String getRandomString() {
        return String.format("%02d", ThreadLocalRandom.current().nextInt(100));
    }

    /**
     * 随机数（手机验证码）
     *
     * @return
     */
    public static String getRandomCode() {
        return String.format("%04d", ThreadLocalRandom.current().nextInt(10000));
    }
}
