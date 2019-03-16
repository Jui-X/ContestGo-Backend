package com.contestgo.contestgobackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.contestgo.contestgobackend.Mapper")
@ComponentScan("com.contestgo.contestgobackend")
public class ContestgoBankendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContestgoBankendApplication.class, args);
    }

}
