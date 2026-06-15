package com.example.fleshcardservice.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.util.Locale;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final LocalValidatorFactoryBean validatorFactory;

    public WebMvcConfig(LocalValidatorFactoryBean validatorFactory) {
        this.validatorFactory = validatorFactory;
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver resolver = new SessionLocaleResolver();
        resolver.setDefaultLocale(new Locale("uz"));
        return resolver;
    }

    @Override
    public Validator getValidator() {
        return validatorFactory;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new HandlerInterceptor() {

            @Override
            public boolean preHandle(
                    @NonNull HttpServletRequest request,
                    @NonNull HttpServletResponse response,
                    @NonNull Object handler
            ) {
                String lang = request.getHeader("hl");
                if (lang == null || lang.isBlank()) {
                    lang = request.getParameter("hl");
                }
                if (lang != null && !lang.isBlank()) {

                    Locale locale = switch (lang.toLowerCase()) {
                        case "en" -> new Locale("en");
                        case "ru" -> new Locale("ru");
                        default -> new Locale("uz");
                    };

                    var localeResolver = RequestContextUtils.getLocaleResolver(request);
                    if (localeResolver != null) {
                        localeResolver.setLocale(request, response, locale);
                    }
                }
                return true;
            }
        });
    }
}
