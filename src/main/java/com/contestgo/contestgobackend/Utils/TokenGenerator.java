package com.contestgo.contestgobackend.Utils;

import org.springframework.stereotype.Component;

@Component
public interface TokenGenerator {

    public String tokenGenerate(String... strings);
}
