package com.study.loan.business.repository

interface LoanRepository {

    suspend fun findByAccountReference(accountReference: String)
}