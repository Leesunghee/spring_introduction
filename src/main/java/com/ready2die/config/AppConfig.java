package com.ready2die.config;

import com.ready2die.annotation.Lightweight;
import com.ready2die.converter.StringToEmailValueConverter;
import com.ready2die.service.DomainService;
import com.ready2die.spring_introduction.*;
import org.springframework.context.annotation.*;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;

@Configuration
@ComponentScan(basePackages = "com.ready2die", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {DomainService.class})
})
@EnableAspectJAutoProxy(proxyTargetClass = true)
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    @Primary
    @Scope("prototype")
    PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Lightweight
    @Scope("prototype")
    PasswordEncoder sha256PasswordEncoder() {
        return new Sha256PasswordEncoder();
    }

    @Bean(name="dataSource")
    @Profile("development")
    DataSource dataSource() {
        return new DataSourceForDevelopment();
    }

    @Bean
    public ConversionService conversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        conversionService.addConverter(new StringToEmailValueConverter());
        return conversionService;
    }
}
