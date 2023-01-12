package com.study.loan.webservice

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RequestPredicate
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class LoanRouter {

    @Bean
    fun loanRoute(handler: LoanHandler) = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            "/api/v1/loan".nest {
                GET("", RequestPredicates.queryParam("account_reference") { true }, handler::findByAccountReference)
            }
        }
    }

}