package com.ara.auth

import com.ara.auth.database.databaseModule
import com.ara.auth.event.ApplicationInitialized
import com.ara.auth.routes.registerRoutes
import com.fasterxml.jackson.databind.SerializationFeature
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
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    install(Koin) {
        slf4jLogger()
        modules(
            applicationModule,
            databaseModule(application),
        )
    }

    registerRoutes()

    environment.monitor.raise(ApplicationInitialized, this)
}
