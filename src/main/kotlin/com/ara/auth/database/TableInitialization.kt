package com.ara.auth.database

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.SqlLogger
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.Table
import java.util.Collections
import java.util.concurrent.ConcurrentHashMap

class TableInitialization(
    database: Database,
    logger: SqlLogger = StdOutSqlLogger
) {
    private val tables = Collections.newSetFromMap(ConcurrentHashMap<Table, Boolean>())
    private val dao = SyncDao(database, logger)

    fun register(table: Table) = tables.add(table)
    fun unregister(table: Table) = tables.remove(table)

    fun init() = dao.query {
        SchemaUtils.create(*tables.toTypedArray())
    }
}
