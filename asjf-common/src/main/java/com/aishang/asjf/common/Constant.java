package com.aishang.asjf.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * ClassName:Constant <br/>
 * Date:     2017年11月17日 上午11:30:50 <br/>
 *
 * @author whb
 * @see
 * @since JDK 1.8
 */
public class Constant {
    public final static DateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public final static DateFormat DF = new SimpleDateFormat("yyyy-MM-dd");

    public final static String REGEXP1 = "([0-9]{4})-([0-1][0-9])-([0-3][0-9])T([0-2][0-9]):([0-6][0-9]):([0-6][0-9])";
    public final static String REGEXP2 = "([0-9]{4})-([0-1][0-9])-([0-3][0-9])(/t)([0-2][0-9]):([0-6][0-9]):([0-6][0-9])";
    public final static String REGEXP3 = "([0-9]{4})-([0-1][0-9])-([0-3][0-9])";

    public final static String OTHER = "未知";

    public final static String FRIST_ORG_PID = "";

    public final static String STR = "";

}
  
