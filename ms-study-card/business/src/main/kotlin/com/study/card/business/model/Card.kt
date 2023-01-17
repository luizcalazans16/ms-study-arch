package com.study.card.business.model

import java.time.Instant
import java.util.UUID

data class Card(
    val cardReference: UUID,
    val createdAt: Instant
)
