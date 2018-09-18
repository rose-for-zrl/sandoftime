package com.zrl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.zrl.modules.api.mapper")
public class SandOfTimeApplication {
    public static void main(String[] args){
        SpringApplication.run(SandOfTimeApplication.class,args);
    }
}
