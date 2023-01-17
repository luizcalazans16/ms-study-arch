package com.study.card.business.service

import com.study.card.business.model.Card
import com.study.card.business.repository.CardRepository
import org.springframework.stereotype.Service

@Service
class CardService(
    private val repository: CardRepository
) {

    suspend fun findByCardReference(cardReference: String): Card {
        return repository.findByCardReference(cardReference) ?: throw Exception("Card not found")
    }

    suspend fun create(card: Card) {
        repository.create(card)
    }
}
