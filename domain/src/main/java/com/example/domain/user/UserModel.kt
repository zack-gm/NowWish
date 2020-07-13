package com.example.domain.user

interface UserModel {

    suspend fun signIn(user: String, password: String): User
    suspend fun signOut()
}