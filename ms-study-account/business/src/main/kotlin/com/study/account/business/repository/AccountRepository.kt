package com.study.account.business.repository

import com.study.account.business.model.Account

interface AccountRepository {

    suspend fun findByAccountReference(accountReference: String): Account?

    suspend fun create(account: Account): Account
    suspend fun update(account: Account): Account
}
