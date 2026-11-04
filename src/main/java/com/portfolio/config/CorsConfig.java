package com.portfolio.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    // Set ALLOWED_ORIGIN env variable to your Netlify URL (e.g. https://your-site.netlify.app)
    // Falls back to * for local development if not set
    @Value("${allowed.origin:*}")
    private String allowedOrigin;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/contact/**")
                .allowedOriginPatterns(allowedOrigin)
                .allowedMethods("POST", "OPTIONS")
                .allowedHeaders("*")
                .maxAge(3600);
    }
}
