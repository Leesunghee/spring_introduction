package com.ready2die.config;

import com.ready2die.annotation.Lightweight;
import com.ready2die.converter.StringToEmailValueConverter;
import com.ready2die.service.DomainService;
import com.ready2die.spring_introduction.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
@Import({DatasourceEmbeddedConfig.class})
@ComponentScan(basePackages = "com.ready2die", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {DomainService.class})
})
@EnableAspectJAutoProxy(proxyTargetClass = true)
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Autowired
    DatasourceEmbeddedConfig datasourceEmbeddedConfig;

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

//    @Bean(name="dataSource")
//    @Profile("development")
//    DataSource dataSource() {
//        return new DataSourceForDevelopment();
//    }

    @Bean
    public ConversionService conversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        conversionService.addConverter(new StringToEmailValueConverter());
        return conversionService;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        //클래스패스 상에 있는 프로퍼티 파일의 이름을 확장자를 제외하고 지정한다.
        messageSource.setBasename("messages");
        //프로퍼티 파일이 ISO-8859-1이 아니라 UTF-8로 인코딩돼 있다.
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(datasourceEmbeddedConfig.dataSource());
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(datasourceEmbeddedConfig.dataSource( ));
    }
}
