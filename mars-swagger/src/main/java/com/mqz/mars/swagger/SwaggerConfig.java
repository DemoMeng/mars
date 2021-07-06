package com.mqz.mars.swagger;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 青网科技集团 版权所有 © Copyright 2012<br>
 *
 * @Author： 蒙大拿
 * @Date：2021/4/26 3:45 下午
 * @Description
 * @About： https://github.com/DemoMeng
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI()//使用SwaggerBootstrapUI的登陆名及密码校验
public class SwaggerConfig {


    @Value("${swagger.enabled:false}")
    private boolean enable;
    @Value("${swagger.info.title}")
    private String title;
    @Value("${swagger.info.description}")
    private String description;
    @Value("${swagger.info.url}")
    private String url;
    @Value("${swagger.info.contact}")
    private String contact;
    @Value("${swagger.info.version}")
    private String version;


    @Bean(name = "web接口")
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                .apiInfo(apiInfo())
                .groupName("web接口")
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.mqz.simple.life.better.web.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                //.paths(PathSelectors.ant("/api/**"))
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .license("copyRight@mqz")
                .termsOfServiceUrl(url)
                .contact(contact)
                .version(version)
                .build();
    }









}
