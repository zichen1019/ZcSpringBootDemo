package com.zc.common.config.Swagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 访问地址例如：http://127.0.0.1:9091/zc/swagger-ui.html
 *
 * 可用注解：
 *
 *  1.swagger的注解主要在包‘io.swagger.annotations’下，除了以上描述的注解外，还有@ApiImplicitParam,@ApiImplicitParams,@ApiKeyAuthDefinition,@ApiResponse,@ApiResponses,
 *      @Authorization,@AuthorizationScope,@BasicAuthDefinition,@Contact,@Example,@ExampleProperty,
 *      @Extension,@ExtensionProperty,@ExternalDocs,@Info,@License,@OAuth2Definition,@ResponseHeader,
 *      @Scope,@SecurityDefinition,@SwaggerDefinition,@Tag
 *
 *  2.除了swagger自己定义的注解外，还有部分校验注解,注解所在包‘javax.validation.constraints’下，像@Max，@Min,@Size这些也是可用的。
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    /*
    *//**
     * UI页面显示信息
     *//*
    private final String SWAGGER2_API_BASEPACKAGE = "com.zc";
    private final String SWAGGER2_API_TITLE = "梓晨-API";
    private final String SWAGGER2_API_DESCRIPTION = "zc-API文档";
    private final String SWAGGER2_API_VERSION = "1.0.0";
    private final String SWAGGER2_API_CONTACT_NAME = "zc";
    private final String SWAGGER2_API_CONTACTEMAIL = "1510748736@qq.com";
    private final String SWAGGER2_API_CONTACTURL = "https://www.baidu.com";
    private final String SWAGGER2_API_LICENSE = "禁止未经主人同意私自传播";
    private final String SWAGGER2_API_LICENSEURL = "https://www.baidu.com";

    *//**
     * createRestApi
     *
     * @return
     *//*
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER2_API_BASEPACKAGE))
                .paths(PathSelectors.any())
                .build();
    }
    *//**
     * apiInfo
     * @return
     *//*
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(SWAGGER2_API_TITLE)
                .description(SWAGGER2_API_DESCRIPTION)
                .contact(new Contact(SWAGGER2_API_CONTACT_NAME,SWAGGER2_API_CONTACTURL,SWAGGER2_API_CONTACTEMAIL))
                .version(SWAGGER2_API_VERSION)
                .license(SWAGGER2_API_LICENSE)
                .licenseUrl(SWAGGER2_API_LICENSEURL)
                .build();
    }*/
}
