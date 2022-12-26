package com.study.business.model

import java.time.Instant
import java.util.UUID

data class Account(
    val accountReference: UUID,
    val accountNumber: String,
    val customerId: UUID,
    val accountType: String,
    val branchAddress: String,
    val createdAt: Instant
)
