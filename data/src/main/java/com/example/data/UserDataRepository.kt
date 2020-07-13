package com.example.data

import com.example.data.repository.DataSourceUser
import com.example.domain.user.User
import com.example.domain.user.UserRepository

class UserDataRepository(private val dataSourceUser: DataSourceUser): UserRepository {

    override fun signIn(login: String, password: String): User {
        return dataSourceUser.signIn(User::class.java, login, password)
    }

    override fun signOut() {
        dataSourceUser.signOut()
    }

}