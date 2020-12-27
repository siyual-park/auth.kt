package com.ara.auth.database

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SqlLogger
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.Transaction

open class AsyncDao(
    database: Database,
    logger: SqlLogger = StdOutSqlLogger
) {
    private val syncDao = SyncDao(database, logger)

    suspend fun <T> query(statement: Transaction.() -> T) = withContext(Dispatchers.IO) {
        syncDao.query(statement)
    }
}
