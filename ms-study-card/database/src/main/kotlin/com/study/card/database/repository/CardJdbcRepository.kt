package com.study.card.database.repository

import com.study.card.business.model.Card
import com.study.card.business.repository.CardRepository
import com.study.card.database.repository.card.CardSQL
import com.study.card.database.repository.extensions.getNotNull
import io.r2dbc.spi.Row
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.r2dbc.core.awaitSingle
import org.springframework.stereotype.Repository

@Repository
class CardJdbcRepository(
    private val databaseClient: DatabaseClient
) : CardRepository {

    override suspend fun findByCardReference(cardReference: String): Card? {
        return databaseClient.sql(CardSQL.FIND_BY_CARD_REFERENCE)
            .bind("card_reference", cardReference)
            .map { row, _ -> row.toCompleteCard() }
            .one()
            .awaitSingleOrNull()
    }

    override suspend fun create(card: Card): Card {
        return databaseClient.sql(CardSQL.INSERT)
            .bind("card_reference", card.cardReference)
            .bind("created_at", card.createdAt)
            .map { row, _ -> row.toCompleteCard() }
            .awaitSingle()
    }

    private fun Row.toCompleteCard() = Card(
        cardReference = this.getNotNull("card_reference"),
        createdAt = this.getNotNull("created_at")
    )
}
