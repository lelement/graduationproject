package com.example.graduationproject.common;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author:Fengxutong
 * @Date:2020/1/5
 * @Description:小冯同学写点注释吧！
 */
public class Swagger2 {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo( apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.graduationproject.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("使用swagger 生成rest文档")
                .description("生成rest接口")
                .termsOfServiceUrl("http://ssb.com")
                .version("1.0.1")
                .build();
    }
}
