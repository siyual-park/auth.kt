package com.ara.auth

import com.ara.auth.database.databaseModule
import com.ara.auth.event.ApplicationInitialized
import com.ara.auth.jackson.jacksonConfigure
import com.ara.auth.routes.registerRoutes
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.jackson
import org.koin.ktor.ext.Koin
import org.koin.logger.slf4jLogger

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val application = this

    install(ContentNegotiation) {
        jackson {
            jacksonConfigure(this)
        }
    }

    install(Koin) {
        slf4jLogger()
        modules(
            databaseModule(application),
        )
    }

    registerRoutes()

    environment.monitor.raise(ApplicationInitialized, this)
}
