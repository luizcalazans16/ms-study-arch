package com.study.loan.database

import com.study.loan.business.repository.LoanRepository
import org.springframework.stereotype.Repository

@Repository
class LoanR2dbcRepository : LoanRepository {

    override suspend fun findByAccountReference(accountReference: String) {
        TODO("Not yet implemented")
    }
}