package com.zywczas.letsshare

import com.zywczas.letsshare.firebase.FBInitializer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application @Autowired constructor(firebase: FBInitializer)

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}