package com.study.loan.business

import com.study.loan.business.repository.LoanRepository
import org.springframework.stereotype.Service

@Service
class LoanService(
    private val loanRepository: LoanRepository
) {
}