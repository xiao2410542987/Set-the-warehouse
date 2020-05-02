package com.renyu.config;



import com.renyu.StorageApplication;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 //开启swagger2
public class SwaggerConfig implements WebMvcConfigurer {


    //分组
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_12).groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_12).groupName("B");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_12).groupName("C");
    }


    //配置了Swagger的Docker的bean实例
    @Bean
    public Docket docket(Environment environment){
        //设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev", "test");
        //通过environment.acceptsProfiles判断自己是否处在自己设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .host("120.79.46.8")
                .groupName("renyu")
                .enable(flag)//enable是否启动swagger，如果为false，则swagger不能再浏览器中访问
                .select()
                //RequestHandlerSelectors,配置1要扫描接口的方式basePackage("com.renyu.swagger.Controller")
                //any()扫描全部
                //none()全部不扫描
                //withClassAnnotation()扫描类上的注解，参数是一个注解的反射对象
                //withMethodAnnotation扫描方法上的注解
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //paths（）过滤什么路径
                .paths(PathSelectors.any())
                .build();
    }

    //swagger信息apiInfo
    public ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("人鱼", "http://localhost:8080", "2410542987@qq.com");
        return new ApiInfo(
                "renyu的标题",
                "即使再小的帆也能远航",
                "v1.0",
                "http://localhost:8080",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());

    }
}
