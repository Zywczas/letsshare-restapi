package com.zywczas.letsshare.pushnotifictions

import com.zywczas.letsshare.models.MessageResponse
import com.zywczas.letsshare.models.ExpenseNotification
import com.zywczas.letsshare.utils.API_VERSION
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("$API_VERSION/notification")
class NotificationController @Autowired constructor(private val service: NotificationService) {

    @PostMapping(path = ["expense_notification"])
    fun sendNotification(@RequestBody notification: ExpenseNotification): ResponseEntity<MessageResponse> {
        service.pushNotification(notification)
        return ResponseEntity.ok(MessageResponse("Notification accepted."))
    }

}