package com.zywczas.letsshare.pushnotifictions

import com.zywczas.letsshare.Hello
import com.zywczas.letsshare.utils.API_VERSION
import com.zywczas.letsshare.utils.APP_NAME
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("$API_VERSION/notification")
class NotificationController {

    @GetMapping(path = ["hello"])
    fun hello() = ResponseEntity.ok(Hello("$APP_NAME up and running."))

}