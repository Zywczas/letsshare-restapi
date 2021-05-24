package com.zywczas.letsshare.firebase

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.stereotype.Service
import java.io.FileInputStream
import java.io.IOException
import javax.annotation.PostConstruct

@Service
class FBInitializer {

    @PostConstruct
    fun initialize(){
        try {
            val serviceAccount = FileInputStream("./firebase-admin-key.json")
            val options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build()
            FirebaseApp.initializeApp(options)
            serviceAccount.close()
            println("firebase odpalony")
        } catch (e: IOException){
            println("jakis blad")
            e.printStackTrace()
        } catch (e: Exception){
            println("jakis blad")
            e.printStackTrace()
        }
    }
}