package com.tts.swaggerrestaurant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tts.swaggerrestaurant"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(buildApiInfo());
        //Starting with the SwaggerConfig class, we can change the request handler selectors to only
        // select controllers we have created.
        // This will make Swagger ignore the built-in Spring Boot error handler controllers that get pulled in by default.
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title("Menu Items API")
                .description("REST API for interacting with menu items")
                .version("1.0.0")
                .contact(new Contact("Developer Name", "website.com", "developer@website.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
//There is also the ability to customize various display options by adding another
// bean to the configuration class. A common option is to have all the endpoints appear automatically expanded, instead of having to manually click on each one. This is accomplished with the following code.
// There are, of course, lots of other options that can be specified here. See the documentation for details.
    @Bean
    public UiConfiguration buildUiConfig() {
        return UiConfigurationBuilder.builder()
                .docExpansion(DocExpansion.FULL)
                .build();
    }

}
