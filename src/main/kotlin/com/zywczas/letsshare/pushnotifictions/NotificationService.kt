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

    private val ownerNameKey = "ownerName"
    private val groupNameKey = "groupName"

    fun pushNotification(notification: ExpenseNotification){
        println("notification otrzymane")
        var count = 1
        val data = mapOf(Pair(ownerNameKey, notification.ownerName), Pair(groupNameKey, notification.groupName))

        notification.receiversIds.forEach { id ->
            val user = firestoreRefs.userRefs(id).get()[10L, TimeUnit.SECONDS].toObject(User::class.java)
            if (user?.messagingToken != null){
                sendNotification(count, user.messagingToken, data)
                println("do uzytkownika: ${user.name}")
            }
            count ++
        }
    }

    private fun sendNotification(count: Int, token: String, data: Map<String, String>){
        val androidConfig = AndroidConfig.builder().putAllData(data).build()
        val message = Message.builder()
                .setToken(token)
                .setAndroidConfig(androidConfig)
                .build()

        val returnMessage = FirebaseMessaging.getInstance().sendAsync(message).get()
        println("wyslano wiadomosc nr: $count")
    }

}