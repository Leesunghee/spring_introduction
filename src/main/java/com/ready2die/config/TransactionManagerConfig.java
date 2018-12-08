package com.ready2die.config;

import com.ready2die.spring_introduction.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({DatasourceEmbeddedConfig.class})
@EnableTransactionManagement
public class TransactionManagerConfig {

    @Autowired
    DatasourceEmbeddedConfig datasourceEmbeddedConfig;

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(datasourceEmbeddedConfig.dataSource());
    }
}
