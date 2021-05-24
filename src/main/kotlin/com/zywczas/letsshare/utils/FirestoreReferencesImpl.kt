package com.zywczas.letsshare.utils

import com.google.cloud.firestore.DocumentReference
import com.google.firebase.cloud.FirestoreClient
import org.springframework.stereotype.Component

@Component
class FirestoreReferencesImpl : FirestoreReferences {

    private val collectionUsers = "users"

    override val messagingTokenField = "messagingToken"

    override fun userRefs(id: String): DocumentReference{
        println("userRefs z FirestoreReferencesImpl dziala")
        return FirestoreClient.getFirestore()
                .collection(collectionUsers)
                .document(id)
    }

}