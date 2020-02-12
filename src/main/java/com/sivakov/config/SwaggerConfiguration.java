package com.sivakov.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.servlet.ServletContext;

/**
 * The type Swagger configuration.
 *
 * @author tino097
 */
@Configuration
public class SwaggerConfiguration {


    /**
     * Docket docket.
     *
     * @param servletContext the servlet context
     * @return the docket
     */
    @Bean
    public Docket docket(ServletContext servletContext) {
        return new Docket(DocumentationType.SWAGGER_2);
    }

}

