package com.ara.auth

import com.ara.auth.jackson.jacksonConfigure
import com.fasterxml.jackson.databind.ObjectMapper
import io.ktor.server.testing.TestApplicationResponse

val objectMapper = ObjectMapper().apply { jacksonConfigure(this) }

inline fun <reified T> TestApplicationResponse.body(): T {
    return objectMapper.readValue(byteContent, T::class.java)
}
