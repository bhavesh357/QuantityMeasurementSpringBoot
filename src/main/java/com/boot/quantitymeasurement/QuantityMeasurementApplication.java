package com.boot.quantitymeasurement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;
import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class QuantityMeasurementApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuantityMeasurementApplication.class, args);
    }

    @Bean
    public Docket config(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/*"))
                .apis(RequestHandlerSelectors.basePackage("com.boot.quantitymeasurement"))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo(){
        return new ApiInfo(
            "Quantity Measurement Api",
            "Sample api for Quantity Measurement",
            "1.0",
            "free to use",
            new springfox.documentation.service.Contact("Bhavesh Kadam","github.com/bhavesh357","bkadam357@gmail.com"),
            "No License",
            "github.com/bhavesh357",
            Collections.emptyList());
    }

}
