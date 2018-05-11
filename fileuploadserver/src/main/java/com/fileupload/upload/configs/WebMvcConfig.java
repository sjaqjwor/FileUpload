package com.fileupload.upload.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

    @Value("${image.dir}")
    private String dir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.err.println(dir);
        System.err.println(System.getProperty("user.home"));
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:///"+dir);

    }
}
