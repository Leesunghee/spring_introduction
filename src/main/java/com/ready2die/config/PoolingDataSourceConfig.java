package com.ready2die.config;


import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class PoolingDataSourceConfig {

//    @Bean (destroyMethod = "close")
    @Bean
    public DataSource dataSource(@Value("${database.driverClassName}") String driverClassName,
                                 @Value("${database.url}") String url,
                                 @Value("${database.username}") String username,
                                 @Value("${database.password}") String password,
                                 @Value("${cp.maxTotal}") int maxTotal,
                                 @Value("${cp.maxIdle}") int maxIdle,
                                 @Value("${cp.minIdle}") int minIdle,
                                 @Value("${cp.maxWaitMillis}") int maxWaitMillis) {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDefaultAutoCommit(false);
//        dataSource.setMaxTotal(maxTotal);
        dataSource.setMaxIdle(maxIdle);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxWait(maxWaitMillis);
        return dataSource;


    }
}
