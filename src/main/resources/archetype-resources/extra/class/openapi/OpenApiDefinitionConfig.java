#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package ${package}.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import ${package}.config.properties.SwaggerProperties;

@Configuration
public class OpenApiDefinitionConfig {

	@Autowired
	SwaggerProperties swaggerProperties;
	
	@Bean
	public OpenAPI openAPI() {

		Info info = new Info()
				.title(swaggerProperties.getProjectTitle())
				.version(swaggerProperties.getProjectVersion())
				.description(swaggerProperties.getProjectDescription());

		return new OpenAPI()
				.extensions(swaggerProperties.ext())
				.info(info);
	}
}
