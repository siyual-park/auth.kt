package com.ara.auth.routes

import com.ara.auth.service.HelloService
import io.ktor.application.Application
import io.ktor.routing.routing
import org.koin.ktor.ext.inject

fun Application.registerRoutes() {
    val service: HelloService by inject()

    routing {
        rootRoutes(service)
    }
}
