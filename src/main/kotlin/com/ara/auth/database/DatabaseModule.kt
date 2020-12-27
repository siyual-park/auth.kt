package com.ara.auth.database

import com.ara.auth.event.ApplicationInitialized
import io.ktor.application.Application
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Slf4jSqlDebugLogger
import org.jetbrains.exposed.sql.SqlLogger
import org.koin.dsl.module
import org.koin.ktor.ext.get

fun databaseModule(application: Application) = module {
    single { DatabaseConnectionConfig.from(application) }
    single { Database.connect(get<DatabaseConnectionConfig>()) }
    single<SqlLogger> { Slf4jSqlDebugLogger }
    single { TableInitialization(get(), get()) }

    application.environment.monitor.subscribe(ApplicationInitialized) {
        val tableInitialization: TableInitialization = it.get()
        tableInitialization.init()
    }
}
