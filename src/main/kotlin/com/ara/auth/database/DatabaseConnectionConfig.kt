package com.ara.auth.database

import io.ktor.application.Application

interface DatabaseConnectionConfig {
    val url: String
    val driver: String
    val user: String?
    val password: String?

    companion object {
        fun from(application: Application): DatabaseConnectionConfig = object : DatabaseConnectionConfig {
            override val url: String
                get() = application.envDatabaseUrl
            override val driver: String
                get() = application.envDatabaseDriver
            override val user: String?
                get() = application.envDatabaseUser
            override val password: String?
                get() = application.envDatabasePassword
        }
    }
}
