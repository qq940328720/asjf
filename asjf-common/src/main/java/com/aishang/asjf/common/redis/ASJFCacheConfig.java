package com.aishang.asjf.common.redis;

import java.util.HashMap;
import java.util.Map;

public class ASJFCacheConfig {
    //缓存名称
    public static final String CACHE_CUSTOMERS = "customers";
    public static final String CACHE_EMPLOYEES = "employees";
    public static final String CACHE_QR = "qr";
    public static final String CACHE_CUSTOMER_PROFILE = "customer_profile";
    public static final String CACHE_EMPLOYEE_PROFILE = "employee_profile";
    public static final String CACHE_BANKS = "banks";
    public static final String CACHE_CUSTOMER_ORDERS = "customer_orders";

    //缓存有效期（秒）
    private static final Long CUSTOMERS_EXPIRES = 60l * 60l;
    private static final Long EMPLOYEES_EXPIRES = 60l * 60l;
    private static final Long QR_EXPIRES = 60l * 60l;
    public static final Long CUSTOMER_PROFILE_EXPIRES = 60l * 60l;
    public static final Long EMPLOYEE_PROFILE_EXPIRES = 60l * 60l;
    public static final Long BANKS_EXPIRES = 60l * 60l;
    public static final Long CUSTOMER_ORDERS_EXPIRES = 60l * 60l;

    public static final Map<String, Long> EXPIRES = new HashMap<>();

    static {
        EXPIRES.put(CACHE_CUSTOMERS, CUSTOMERS_EXPIRES);
        EXPIRES.put(CACHE_EMPLOYEES, EMPLOYEES_EXPIRES);
        EXPIRES.put(CACHE_QR, QR_EXPIRES);
        EXPIRES.put(CACHE_CUSTOMER_PROFILE, CUSTOMER_PROFILE_EXPIRES);
        EXPIRES.put(CACHE_EMPLOYEE_PROFILE, EMPLOYEE_PROFILE_EXPIRES);
        EXPIRES.put(CACHE_BANKS, BANKS_EXPIRES);
        EXPIRES.put(CACHE_CUSTOMER_ORDERS, CUSTOMER_ORDERS_EXPIRES);
    }
}
