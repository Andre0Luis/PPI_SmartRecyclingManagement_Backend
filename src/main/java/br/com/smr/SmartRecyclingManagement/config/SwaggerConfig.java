package br.com.smr.SmartRecyclingManagement.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi smartRecyclingManagementApi() {
        return GroupedOpenApi.builder()
                .group("SmartRecyclingManagement")
                .packagesToScan("br.com.smr.SmartRecyclingManagement")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("SRM - Smart Recycling Management")
                        .version("v1.0.0")
                        .description("SRM - Smart Recycling Management, é uma API para ajudar a gerenciar o processo de reciclagem de materiais e monitorar seu consumo mensal sobre eles."));
    }



}
