package com.dlesniok.githubproject.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

//@Component
//public class ObjectMapperConfiguration {
//    private static final Set<String> ignorableFieldNames = new HashSet<>();
//
//    static {
//        ignorableFieldNames.add("phoneNumber");
//    }
//
//    @Bean
//    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider().setFailOnUnknownId(false);
//        FilterProvider filters = simpleFilterProvider.addFilter("customerFilter", SimpleBeanPropertyFilter.ser(ignorableFieldNames));
//        objectMapper.setFilterProvider(filters);
//
//        jsonConverter.setObjectMapper(objectMapper);
//        return jsonConverter;
//    }
//}