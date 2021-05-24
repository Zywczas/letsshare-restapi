package com.zywczas.letsshare

import com.zywczas.letsshare.models.MessageResponse
import com.zywczas.letsshare.utils.API_VERSION
import com.zywczas.letsshare.utils.APP_NAME
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("$API_VERSION/server")
class AppController {

    /**
     * Simple function to wake up the Heroku server,
     * as it falls asleep after 30 minutes of being idle.
     */
    @GetMapping(path = ["wake_up"])
    fun wakeUp() = ResponseEntity.ok(MessageResponse("$APP_NAME up and running."))

}