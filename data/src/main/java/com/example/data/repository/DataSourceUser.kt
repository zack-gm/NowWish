package com.example.data.repository

import com.example.domain.user.User

interface DataSourceUser{
    fun <T> signIn(clazz: Class<T>, login: String, password: String) : T
    fun signOut()
}