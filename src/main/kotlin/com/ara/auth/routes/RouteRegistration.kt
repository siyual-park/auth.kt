package com.ara.auth.routes

import io.ktor.application.Application
import io.ktor.routing.routing

fun Application.registerRoutes() {
    routing {
        versionRoutes()
    }
}
