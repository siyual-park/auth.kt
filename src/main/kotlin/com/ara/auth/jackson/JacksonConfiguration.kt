package com.ara.auth.jackson

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature

fun jacksonConfigure(objectMapper: ObjectMapper) = with(objectMapper) {
    enable(SerializationFeature.INDENT_OUTPUT)
}
