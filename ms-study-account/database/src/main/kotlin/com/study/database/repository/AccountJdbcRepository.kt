package com.study.database.repository

import com.study.business.model.Account
import com.study.business.repository.AccountRepository
import com.study.database.repository.account.AccountSQL
import io.r2dbc.spi.Row
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.r2dbc.core.awaitSingle
import org.springframework.stereotype.Repository

@Repository
class AccountJdbcRepository(
    private val databaseClient: DatabaseClient
) : AccountRepository {

    override suspend fun findByAccountReference(accountNumber: String) {
        TODO("Not yet implemented")
    }

    override suspend fun create(account: Account): Account {
        return databaseClient.sql(AccountSQL.INSERT)
            .bind("account_reference", account.accountReference)
            .bind("account_number", account.accountNumber)
            .bind("customer_id", account.customerId)
            .bind("account_type", account.accountType)
            .bind("branch_address", account.branchAddress)
            .bind("created_at", account.createdAt)
            .map { row, _ -> row.toCompleteAccount() }
            .awaitSingle()
    }

    private fun Row.toCompleteAccount() = Account(
        accountReference = this.getNotNull("account_reference"),
        accountNumber = this.getNotNull("account_number"),
        customerId = this.getNotNull("customer_id"),
        accountType = this.getNotNull("account_type"),
        branchAddress = this.getNotNull("branch_address"),
        createdAt = this.getNotNull("created_at")
    )
}
