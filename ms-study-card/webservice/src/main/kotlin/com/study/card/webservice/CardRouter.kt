package com.study.card.webservice

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class CardRouter {

    @Bean
    fun cardRoute(handler: CardHandler) = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            "/api/v1/cards".nest {
                GET("", RequestPredicates.queryParam("card_reference") { true }, handler::findByCardReference)
                POST("", handler::create)
            }
        }
    }
}
