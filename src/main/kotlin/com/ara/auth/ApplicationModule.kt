package com.ara.auth

import com.ara.auth.repository.HelloRepository
import com.ara.auth.service.HelloService
import com.ara.auth.service.HelloServiceImpl
import org.koin.dsl.module

val applicationModule = module {
    single<HelloService> { HelloServiceImpl(get()) }
    single { HelloRepository() }
}
