package br.com.smr.SmartRecyclingManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories
@EnableSwagger2WebMvc
@SpringBootApplication
public class SmartRecyclingManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartRecyclingManagementApplication.class, args);
	}

}
