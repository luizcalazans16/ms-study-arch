package com.study.webservice.account

import com.study.business.service.AccountService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.buildAndAwait
import org.springframework.web.reactive.function.server.queryParamOrNull

@Component
class AccountHandler(
    private val accountService: AccountService
) {

    suspend fun findByAccountReference(request: ServerRequest): ServerResponse {
        val accountReference = request.queryParamOrNull("account_reference") ?: throw Exception("AccountReference should not be null!")

        return ServerResponse.ok().bodyValueAndAwait(accountService.findByAccountReference(accountReference))
    }

    suspend fun create(request: ServerRequest): ServerResponse {
        accountService.create(request.awaitBody())
        return ServerResponse.ok().buildAndAwait()
    }
}
