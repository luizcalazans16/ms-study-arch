package com.study.account.business.service

import com.study.account.business.model.Account
import com.study.account.business.repository.AccountRepository
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class AccountService(
    private val repository: AccountRepository
) {

    companion object : KLogging()

    suspend fun findByAccountReference(accountReference: String): Account {
        logger.info { "Finding account [$accountReference]" }
        return repository.findByAccountReference(accountReference) ?: throw Exception("Account not found")
    }

    suspend fun create(account: Account) {
        logger.info { "Creating account [$account]" }
        repository.create(account)
    }

    suspend fun update(account: Account) {
        logger.info { "Updating account [$account]" }

        val storedAccount = findByAccountReference(accountReference = account.accountReference.toString())

        repository.update(storedAccount)
    }
}
