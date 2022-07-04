
package com.example.plan;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author admin
 */
@Configuration
public class ImgConfig implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry); 
        registry.addResourceHandler("/files1/**").addResourceLocations("file:/E:/recursos/images/files1/");
        registry.addResourceHandler("/files2/**").addResourceLocations("file:/E:/recursos/images/files2/");
    }
    
}
