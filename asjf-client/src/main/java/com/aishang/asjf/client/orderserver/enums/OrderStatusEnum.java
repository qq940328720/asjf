package com.aishang.asjf.client.orderserver.enums;

import java.util.HashMap;
import java.util.Map;

public enum OrderStatusEnum {

    DATA_FILLIN(1, "资料填写中"),

    SUDMITTED_LETTER(2, "已提交,待信审"),

    LETTER_IN(3, "信审中"),

    WAIT_PICKUPGOODS(4, "信审完成,待提货"),

    LETTER_BY(5, "资料待审核"),

    AUDIT_ING(6, "审核中"),

    WAIT_PAY(7, "审核完成,待打款"),

    PAY_MONEY_ING(8, "打款中"),

    WAIT_PAYBACK(9, "还款中"),

    PAYBACK_FINISH(10, "已取消"),

    COMPLETE(11, "完成"),

    REFUSED(12, "拒绝");

    private final Integer status;
    private final String displayName;
    private static Map<Integer, OrderStatusEnum> valueMap;

    OrderStatusEnum(Integer status, String displayName) {
        this.status = status;
        this.displayName = displayName;
    }

    static {
        valueMap = new HashMap();
        for (OrderStatusEnum e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static OrderStatusEnum getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, OrderStatusEnum> getAllValueMap() {
        return valueMap;
    }

    public String getEnumName() {
        return this.name();
    }


}
