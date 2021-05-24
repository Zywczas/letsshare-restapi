package com.zywczas.letsshare.utils

import com.google.cloud.firestore.DocumentReference

interface FirestoreReferences {

    val messagingTokenField: String

    fun userRefs(id: String): DocumentReference

}