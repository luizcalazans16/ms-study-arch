package com.study.loan.webservice

import com.study.loan.business.LoanService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.buildAndAwait

@Component
class LoanHandler(
    private val loanService: LoanService
) {

    suspend fun findByAccountReference(request: ServerRequest) : ServerResponse {
        return ServerResponse.ok().buildAndAwait()
    }
}
