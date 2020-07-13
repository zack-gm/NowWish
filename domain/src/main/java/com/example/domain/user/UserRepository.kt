package com.example.domain.user

interface UserRepository {
    fun signIn(login: String, password: String): User
    fun signOut()
}