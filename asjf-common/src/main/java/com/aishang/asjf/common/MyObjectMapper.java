package com.aishang.asjf.common;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 单例，全局ObjectMapper
 */
public class MyObjectMapper {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static ObjectMapper getInstance() {
        return OBJECT_MAPPER;
    }
}
