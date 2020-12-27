package com.ara.auth.services

import com.ara.auth.repositories.HelloRepository

class HelloServiceImpl(private val helloRepository: HelloRepository) : HelloService {
    override fun sayHello() = "Hello ${helloRepository.getHello()} !"
}
