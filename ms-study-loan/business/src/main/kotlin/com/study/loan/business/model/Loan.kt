package com.study.loan.business.model

import java.util.UUID

data class Loan(
    val id: UUID,
    val amount: Double
)
