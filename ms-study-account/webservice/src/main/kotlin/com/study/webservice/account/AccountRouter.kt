package com.study.webservice.account

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class AccountRouter {

    @Bean
    fun accountRoute(handler: AccountHandler) = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            "/api/v1/accounts".nest {
                GET("", RequestPredicates.queryParam("account_reference") { true }, handler::findByAccountReference)
                POST("", handler::create)
                PUT("/{accountReference}", handler::update)
            }
        }
    }
}
