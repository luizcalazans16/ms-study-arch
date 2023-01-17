package com.study.loan.database.repository

import com.study.loan.business.model.Loan
import com.study.loan.business.repository.LoanRepository
import org.springframework.stereotype.Repository

@Repository
class LoanR2dbcRepository : LoanRepository {

    override suspend fun findByAccountReference(accountReference: String) {
        TODO("Not yet implemented")
    }

    override suspend fun create(entity: Loan): Loan {
        TODO("Not yet implemented")
    }
}