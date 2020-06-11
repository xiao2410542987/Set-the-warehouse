package com.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@Configuration
@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages ={"com.storage.mapper.xml"})
//@EnableTransactionManagement(proxyTargetClass = true)
public class StorageApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder Application) {
        return Application.sources(StorageApplication.class);
    }

}
