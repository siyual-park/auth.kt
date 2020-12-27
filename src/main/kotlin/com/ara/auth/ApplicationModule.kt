package com.ara.auth

import com.ara.auth.repositories.HelloRepository
import com.ara.auth.services.HelloService
import com.ara.auth.services.HelloServiceImpl
import org.koin.dsl.module

val applicationModule = module {
    single<HelloService> { HelloServiceImpl(get()) }
    single { HelloRepository() }
}
