package com.ara.auth

import io.ktor.application.Application
import io.ktor.config.MapApplicationConfig

val testModule: Application.() -> Unit = {
    (environment.config as MapApplicationConfig).apply {
        put("database.url", "jdbc:h2:mem:test")
        put("database.driver", "org.h2.Driver")
    }

    module(testing = true)
}
