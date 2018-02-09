package com.aishang.asjf.facade.dto.request.salesman.emun;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.EnumSerializer;

@JsonSerialize(using = EnumSerializer.class)
public interface BaseEnum<ENUM extends Enum<?>, KEYTYPE> {
    KEYTYPE getValue();

    String getDisplayName();

    String getEnumName();


}