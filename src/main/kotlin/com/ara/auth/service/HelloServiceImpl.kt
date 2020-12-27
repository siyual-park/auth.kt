package com.ara.auth.service

import com.ara.auth.repository.HelloRepository

class HelloServiceImpl(private val helloRepository: HelloRepository) : HelloService {
    override fun sayHello() = "Hello ${helloRepository.getHello()} !"
}
