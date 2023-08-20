package com.cos.blog.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private static final Contact DEFAULT_CONTACT = new Contact("zimmyrabbit"
			,"https://github.com/zimmyrabbit","zimmyrabbit@naver.com");
	
	private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Restful-web-service"
			,"Restful-web-service config","1.0","urn:tos",DEFAULT_CONTACT,"Apache 2.0"
			, "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());
	
	private static final Set<String> DEFAULT_PRODUCE_AND_CONSUMES = new HashSet<>(
			Arrays.asList("application/json", "application/xml"));
	
	//http://localhost:8088/v2/api-docs
	//http://localhost:8088/swagger-ui/index.html
	
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(DEFAULT_API_INFO)
        		.produces(DEFAULT_PRODUCE_AND_CONSUMES)
        		.consumes(DEFAULT_PRODUCE_AND_CONSUMES);
        		/*
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
                */
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Restful-web-service")
                .description("Restful-web-service config")
                .version("1.0")
                .build();
    }
}
