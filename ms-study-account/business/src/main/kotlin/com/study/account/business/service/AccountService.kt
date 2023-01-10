package com.study.account.business.service

import com.study.account.business.model.Account
import com.study.account.business.repository.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountService(
    private val repository: AccountRepository
) {

    suspend fun findByAccountReference(accountReference: String): Account {
        return repository.findByAccountReference(accountReference) ?: throw Exception("Account not found")
    }

    suspend fun create(account: Account) {
        repository.create(account)
    }
}
