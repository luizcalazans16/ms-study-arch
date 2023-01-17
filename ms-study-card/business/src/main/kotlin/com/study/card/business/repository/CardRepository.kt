package com.study.card.business.repository

import com.study.card.business.model.Card

interface CardRepository {

    suspend fun findByCardReference(cardReference: String): Card?

    suspend fun create(card: Card): Card
}
