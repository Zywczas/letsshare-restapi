package com.zywczas.letsshare.pushnotifictions

import com.zywczas.letsshare.models.ApiResponse
import com.zywczas.letsshare.models.ExpenseNotification
import com.zywczas.letsshare.utils.API_VERSION
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("$API_VERSION/notification")
class NotificationController {

    @PostMapping(path = ["expense_notification"])
    fun sendNotification(@RequestBody notification: ExpenseNotification): ResponseEntity<ApiResponse> {
        println(notification)
        //todo - moze dac korutyny
        return ResponseEntity.ok(ApiResponse("Notification accepted."))
    }

}