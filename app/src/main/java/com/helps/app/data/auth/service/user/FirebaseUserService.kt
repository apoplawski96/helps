package com.helps.app.data.auth.service.user

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class FirebaseUserService(
    private val firebaseAuthInstance: FirebaseAuth
) : UserAPI {

    override fun getCurrentUser(): FirebaseUser? = firebaseAuthInstance.currentUser
}