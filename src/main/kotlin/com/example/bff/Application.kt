package com.example.bff

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableAutoConfiguration
@SpringBootApplication
@EnableFeignClients
class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
	