package com.study.webservice.account

import com.study.business.model.Account
import com.study.business.service.AccountService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.buildAndAwait

@Component
class AccountHandler(
    private val accountService: AccountService
) {

    suspend fun create(request: ServerRequest): ServerResponse {
        accountService.create(request.awaitBody())
        return ServerResponse.ok().buildAndAwait()
    }
}
