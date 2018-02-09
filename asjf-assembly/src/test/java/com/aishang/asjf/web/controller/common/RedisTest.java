package com.aishang.asjf.web.controller.common;

import com.aishang.asjf.assembly.config.db.DataSourceConfig;
import com.aishang.asjf.assembly.config.mvc.AppWebConfiguration;
import com.aishang.asjf.common.MyObjectMapper;
import com.aishang.asjf.common.enums.ErrorCode;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.security.access.SecurityConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {DataSourceConfig.class, AppWebConfiguration.class, SecurityConfig.class})
public class RedisTest {

    @Test
    void name() throws Exception {
        MyObjectMapper.getInstance().writeValue(System.out, ErrorCode.values());
    }
}
