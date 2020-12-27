package com.ara.auth.routes

import com.ara.auth.services.HelloService
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get

fun Route.rootRoutes(service: HelloService) {
    get("/") {
        call.respondText(service.sayHello(), contentType = ContentType.Text.Plain)
    }

    get("/json/jackson") {
        call.respond(mapOf("hello" to "world"))
    }
}
