package com.zywczas.letsshare

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.net.InetAddress

@SpringBootApplication
class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)
	println("LOCAL IP ADDRESS: " + InetAddress.getLocalHost().hostAddress)
}