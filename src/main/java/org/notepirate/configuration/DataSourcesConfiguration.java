package org.notepirate.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourcesConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "application.datasources.postgresql")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

}
