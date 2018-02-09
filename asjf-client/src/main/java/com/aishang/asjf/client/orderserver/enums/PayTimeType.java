package com.aishang.asjf.client.orderserver.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 期数
 * date: 2018-01-21
 *
 * @author whb
 * @version 1.0
 * @since JDK 1.8
 */
public enum PayTimeType {

    ONE((byte)1, "第一期"),
    TWO((byte)2, "第二期"),
    THREE((byte)3, "第三期"),
    FOUR((byte)4, "第四期"),
    FIVE((byte)5, "第五期"),
    SIX((byte)6, "第六期"),
    SEVEN((byte)7, "第七期"),
    EIGHT((byte)8, "第八期"),
    NINE((byte)9, "第九期"),
    TEN((byte)10, "第十期"),
    ELEVEN((byte)11, "第十一期"),
    TWELVE((byte)12, "第十二期"),
    THIRTEEN((byte)13, "第十三期"),
    FOURTEEN((byte)14, "第十四期"),
    FIFTEEN((byte)15, "第十五期"),
    SIXTEEN((byte)16, "第十六期"),
    SEVENTEEN((byte)17, "第十七期"),
    EIGHTTEEN((byte)18, "第十八期"),
    NINETEEN((byte)19, "第十九期"),
    TWENTY((byte)20, "第二十期"),
    TWENTY_ONE((byte)21, "第二十一期"),
    TWENTY_TWO((byte)22, "第二十二期"),
    TWENTY_THREE((byte)23, "第二十三期"),
    TWENTY_FOUR((byte)24, "第二十四期"),
    TWENTY_FIVE((byte)25, "第二十五期"),
    TWENTY_SIX((byte)26, "第二十六期"),
    TWENTY_SEVEN((byte)27, "第二十七期"),
    TWENTY_EIGHT((byte)28, "第二十八期"),
    TWENTY_NINE((byte)23, "第二十九期"),
    TIRTY((byte)30, "第三十期"),
    TIRTY_ONE((byte)31, "第三十一期"),
    TIRTY_TWO((byte)32, "第三十二期"),
    TIRTY_THREE((byte)33, "第三十三期"),
    TIRTY_FOUR((byte)34, "第三十四期"),
    TIRTY_FIVE((byte)35, "第三十五期"),
    TIRTY_SIX((byte)36, "第三十六期"),
    ;


    private final Byte status;
    private final String displayName;
    private static Map<Byte, PayTimeType> valueMap;

    PayTimeType(Byte status, String displayName) {
        this.status = status;
        this.displayName = displayName;
    }

    static {
        valueMap = new HashMap();
        for (PayTimeType e : values())
            valueMap.put(e.status, e);
    }

    public Byte getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static PayTimeType getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Byte, PayTimeType> getAllValueMap() {
        return valueMap;
    }

    public String getEnumName() {
        return this.name();
    }

}
