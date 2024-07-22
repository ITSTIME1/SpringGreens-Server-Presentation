package com.spring_greens.presentation.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Swagger is api testing library. <br>
 * below does not have jwt config setting. <br>
 * if any controller does not have @Tag, swagger name set to split {specific name}-controller.
 * @author itsitme0809
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(info());
    }
    private Info info() {
        return new Info()
                .title("SpringGreensPresentation-API")
                .description("Map & Main Test")
                .version("1.0.0");
    }
}
