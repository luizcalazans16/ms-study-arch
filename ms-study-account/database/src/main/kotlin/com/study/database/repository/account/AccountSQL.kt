package com.study.database.repository.account

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

    val INSERT = """
        INSERT INTO $TABLE_NAME (
            $ALL_COLUMNS
        )
         VALUES (
            $ALL_BINDS
        )
    """.trimIndent()
}
