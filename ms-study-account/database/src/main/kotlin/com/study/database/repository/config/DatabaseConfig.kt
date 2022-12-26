package com.study.database.repository.config

import io.r2dbc.h2.H2ConnectionConfiguration
import io.r2dbc.h2.H2ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DatabaseConfig {

    @Bean
    fun h2ConnectionFactory(): H2ConnectionFactory =
        H2ConnectionFactory(
            H2ConnectionConfiguration.builder()
                .inMemory("testdb")
                .build()
        )
}