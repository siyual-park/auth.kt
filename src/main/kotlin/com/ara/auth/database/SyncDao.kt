package com.ara.auth.database

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SqlLogger
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

open class SyncDao(
    private val database: Database,
    private val logger: SqlLogger = StdOutSqlLogger
) {
    fun <T> query(statement: Transaction.() -> T) = transaction(database) {
        addLogger(logger)
        statement(this)
    }
}
