package com.mukun.albumserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//将dao层中的映射接口注入到容器中
@MapperScan("com.mukun.albumserver.dao")
@SpringBootApplication
public class AlbumserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlbumserverApplication.class, args);
    }

}
