package com.example.firebase_wish

import com.example.data.repository.DataSourceUser
import com.google.firebase.auth.FirebaseAuth

class FireAuth: DataSourceUser {
    private lateinit var auth: FirebaseAuth
    override fun <T> signIn(clazz: Class<T>, login: String, password: String): T {
        TODO("Not yet implemented")
    }

    override fun signOut() {
        TODO("Not yet implemented")
    }


}