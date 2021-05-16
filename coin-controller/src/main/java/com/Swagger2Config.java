package com;

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
 * @ClassName Swagger2Config
 * @Description: TODO
 * @Author shiyawei
 * @Date 2021/5/5
 * @Version V1.0
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket helloApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.cnbisoft.demo"))
                .paths(PathSelectors.any())
                .build();
    }

    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("api文档")
                //描述
                .description("搭建spring boot+mybatis+maven+swagger的测试项目")
                .termsOfServiceUrl("http://接口IP")
                //版本号
                .version("v1")
                .build();
    }

}