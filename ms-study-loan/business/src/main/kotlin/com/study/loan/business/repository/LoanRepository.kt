package com.study.loan.business.repository

import com.study.loan.business.model.Loan

interface LoanRepository {

    suspend fun findByAccountReference(accountReference: String)

    suspend fun create(entity: Loan) : Loan
}