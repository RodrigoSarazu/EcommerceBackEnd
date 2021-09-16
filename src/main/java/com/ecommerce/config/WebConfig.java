package com.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
	//realiza peticiones al servicio para que no tenga ningun problema
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		registry.addMapping("/**")
		.allowedOrigins("#")
		.allowedMethods("GET","POST","PUT","DELETE","HEAD")
		.allowCredentials(true);
		
		/*WebMvcConfigurer.super.addCorsMappings(registry);
		 - creado por defecto por la clase addCors
		 */
	}

}
