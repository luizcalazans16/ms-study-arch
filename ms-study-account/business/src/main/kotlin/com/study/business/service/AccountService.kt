package com.study.business.service

import com.study.business.model.Account
import com.study.business.repository.AccountRepository

import org.springframework.stereotype.Service

@Service
class AccountService(
    private val repository: AccountRepository
) {

    suspend fun create(account: Account) {
        repository.create(account)
    }
}