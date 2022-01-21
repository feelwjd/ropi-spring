package com.ropi.ropispring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.ropi.ropispring.Controller" })
public class WebConfig extends WebMvcConfigurerAdapter {
   private final int MAX_SIZE = 20 * 1024 * 1024;
   
   @Bean
   public MultipartResolver multipartResolver() {
      CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
      multipartResolver.setMaxUploadSize(MAX_SIZE); // 20MB
      multipartResolver.setMaxUploadSizePerFile(MAX_SIZE); // 20MB
      multipartResolver.setMaxInMemorySize(0);
      return multipartResolver;
   }
}