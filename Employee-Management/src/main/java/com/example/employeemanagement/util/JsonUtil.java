package com.example.employeemanagement.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.example.employeemanagement.constant.CommonConstant;

import java.text.SimpleDateFormat;

public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .setDateFormat(new SimpleDateFormat(CommonConstant.PATTERN_DATE));
    public static String toJson(Object obj) throws JsonProcessingException {

            return objectMapper.writeValueAsString(obj);
    }
}
