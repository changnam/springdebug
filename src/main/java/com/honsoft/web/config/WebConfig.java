package com.honsoft.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan({"com.honsoft.web"})
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/jsp/", ".jsp");
		WebMvcConfigurer.super.configureViewResolvers(registry);
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorParameter(true).ignoreAcceptHeader(false).defaultContentType(MediaType.APPLICATION_JSON)
				.mediaType("xml", MediaType.APPLICATION_XML).mediaType("json", MediaType.APPLICATION_JSON);
	}
	
}