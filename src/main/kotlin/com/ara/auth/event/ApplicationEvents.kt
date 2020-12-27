package com.ara.auth.event

import io.ktor.application.Application
import io.ktor.application.EventDefinition

val ApplicationInitialized: EventDefinition<Application> = EventDefinition<Application>()
