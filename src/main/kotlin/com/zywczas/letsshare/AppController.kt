package com.zywczas.letsshare

import com.zywczas.letsshare.utils.APP_NAME
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AppController {

    @GetMapping
    fun getIsWorkingInfo() = "$APP_NAME is up and running!"

}