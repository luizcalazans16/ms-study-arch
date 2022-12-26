package com.study.business.repository

import com.study.business.model.Account

interface AccountRepository {

    suspend fun findByAccountReference(accountNumber: String)

    suspend fun create(account: Account): Account
}
