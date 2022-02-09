package com.ropi.ropispring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.ropi.ropispring.Controller" })
public class WebConfig implements WebMvcConfigurer {
   private final int MAX_SIZE = 20 * 1024 * 1024;
   
   @Bean
   public MultipartResolver multipartResolver() {
	   System.out.println("multipart check");
      CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
      multipartResolver.setMaxUploadSize(MAX_SIZE); // 20MB
      multipartResolver.setMaxUploadSizePerFile(MAX_SIZE); // 20MB
      multipartResolver.setMaxInMemorySize(0);
      return multipartResolver;
   }
   
   @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
//		WebMvcConfigurer.super.addResourceHandlers(registry);
	   registry.addResourceHandler("/**")
	   			.addResourceLocations("classpath:/templates/", "classpath:/static/");
	}
}