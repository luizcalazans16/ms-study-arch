package com.study.card.database.repository.card

object CardSQL {

    private const val TABLE_NAME = "cards"

    private const val ALL_COLUMNS = """
        card_reference,
        created_at
    """

    private const val ALL_BINDS = """
        :card_reference,
        :created_at
    """

    val FIND_BY_CARD_REFERENCE = """
        SELECT $ALL_COLUMNS
            FROM $TABLE_NAME c
            WHERE c.card_reference = :card_reference
    """.trimIndent()

    val INSERT = """
        INSERT INTO $TABLE_NAME (
            $ALL_COLUMNS
        )
         VALUES (
            $ALL_BINDS
        )
    """.trimIndent()
}
