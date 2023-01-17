package com.study.card.webservice

import com.study.card.business.service.CardService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.buildAndAwait
import org.springframework.web.reactive.function.server.queryParamOrNull

@Component
class CardHandler(
    private val cardService: CardService
) {

    suspend fun findByCardReference(request: ServerRequest): ServerResponse {
        val cardReference = request.queryParamOrNull("card_reference") ?: throw Exception("cardReference should not be null!")

        return ServerResponse.ok().bodyValueAndAwait(cardService.findByCardReference(cardReference))
    }

    suspend fun create(request: ServerRequest): ServerResponse {
        cardService.create(request.awaitBody())
        return ServerResponse.ok().buildAndAwait()
    }
}
