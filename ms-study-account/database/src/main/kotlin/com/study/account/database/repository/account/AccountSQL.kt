package com.study.account.database.repository.account

object AccountSQL {

    private const val TABLE_NAME = "accounts"

    private const val ALL_COLUMNS = """
        account_reference,
        account_number,
        customer_id,
        account_type,
        branch_address,
        created_at
    """

    private const val ALL_BINDS = """
        :account_reference,
        :account_number,
        :customer_id,
        :account_type,
        :branch_address,
        :created_at
    """

    val FIND_BY_ACCOUNT_REFERENCE = """
        SELECT $ALL_COLUMNS
            FROM $TABLE_NAME a
            WHERE a.account_reference = :account_reference
    """.trimIndent()

    val INSERT = """
        INSERT INTO $TABLE_NAME (
            $ALL_COLUMNS
        )
         VALUES (
            $ALL_BINDS
        )
    """.trimIndent()

    val UPDATE = """
        UPDATE $TABLE_NAME
            SET stat
    """.trimIndent()
}
