package com.zywczas.letsshare

import com.zywczas.letsshare.utils.APP_NAME
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AppController {

    /**
     * Simple function to wake up the Heroku server,
     * as it falls asleep after 30 minutes of being idle.
     */
    @GetMapping
    fun hello() = ResponseEntity.ok("$APP_NAME up and running.")

}