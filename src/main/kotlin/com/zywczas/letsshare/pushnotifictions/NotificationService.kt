package com.zywczas.letsshare.pushnotifictions

import com.google.firebase.messaging.AndroidConfig
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import com.zywczas.letsshare.models.ExpenseNotification
import com.zywczas.letsshare.models.User
import com.zywczas.letsshare.utils.FirestoreReferences
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class NotificationService @Autowired constructor(private val firestoreRefs: FirestoreReferences) {

    private val messageContentKey = "content"

    fun pushNotification(notification: ExpenseNotification){
        val message = "${notification.ownerName} has added new expense to ${notification.groupName}"
        val data = mapOf(Pair(messageContentKey, message))

        notification.receiversIds.forEach { id ->
            val user = firestoreRefs.userRefs(id).get()[10L, TimeUnit.SECONDS].toObject(User::class.java)
            if (user?.messagingToken != null){
                sendNotification(user.messagingToken, data)
            }
        }
    }

    private fun sendNotification(token: String, data: Map<String, String>){
        val androidConfig = AndroidConfig.builder().putAllData(data).build()
        val message = Message.builder()
                .setToken(token)
                .setAndroidConfig(androidConfig)
                .build()

        val returnMessage = FirebaseMessaging.getInstance().sendAsync(message).get()
        print(returnMessage)
    }

}