package com.contestgo.contestgobackend.utils;

import org.springframework.stereotype.Component;

@Component
public interface TokenGenerator {

    public String tokenGenerate(String... strings);
}
