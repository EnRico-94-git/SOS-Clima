package br.com.fiap.projeto_sosclima.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfiguration {
	
	@Bean
	OpenAPI configurarSwagger() {
		
		return new OpenAPI().info(new Info()
											.title("Projeto de Monitoramento de Eventos Climáticos")
											.description("Este projeto oferece uma implementação que possibilita "
													+ "a gestão de eventos climáticos ao redor do mundo"
													+ "e em quais locais ocorreram ou ocorrem.")
											.version("v1.0.0")
											.license(new License().url("www.fiap.com.br")
																  .name("Licença - Projeto de Monitoramento de Eventos Climáticos - v1.0.0"))
											.termsOfService("Termos de Serviço"));
		
	}

}
