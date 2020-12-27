package com.ara.auth.routes

import com.ara.auth.entity.version.PackageVersion
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route

fun Route.versionRoutes() {
    route("/version") {
        get("/") {
            call.respond(PackageVersion)
        }
    }
}
