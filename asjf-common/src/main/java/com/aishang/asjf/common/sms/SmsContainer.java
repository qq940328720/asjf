package com.aishang.asjf.common.sms;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SmsContainer {

    private static final Map<String, SmsBean> cache = new HashMap<>();

    public static void put(String account, SmsBean smsBean) {
        cache.put(account, smsBean);
    }

    public static SmsBean get(String account) {
        return cache.get(account);
    }

    public static void remove(String account) {
        cache.remove(account);
    }

    public static class SmsBean {
        private String code;
        private long createdAt;

        @Override
        public String toString() {
            return "SmsBean{" +
                    "code='" + code + '\'' +
                    ", createdAt=" + createdAt +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SmsBean smsBean = (SmsBean) o;
            return createdAt == smsBean.createdAt &&
                    Objects.equals(code, smsBean.code);
        }

        @Override
        public int hashCode() {
            return Objects.hash(code, createdAt);
        }

        public String getCode() {

            return code;
        }

        public long getCreatedAt() {
            return createdAt;
        }

        public SmsBean(String code, long createdAt) {

            this.code = code;
            this.createdAt = createdAt;
        }
    }
}
