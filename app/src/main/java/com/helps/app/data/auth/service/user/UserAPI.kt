package com.helps.app.data.auth.service.user

import com.google.firebase.auth.FirebaseUser

interface UserAPI {

    fun getCurrentUser(): FirebaseUser?
}