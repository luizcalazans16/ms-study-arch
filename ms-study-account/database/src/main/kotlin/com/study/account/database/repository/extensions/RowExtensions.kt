package com.study.account.database.repository.extensions

import io.r2dbc.spi.Row
inline fun <reified T : Any> Row.getNotNull(identifier: String): T = this.get(identifier, T::class.java)!!
