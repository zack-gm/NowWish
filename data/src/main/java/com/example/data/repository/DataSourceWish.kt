package com.example.data.repository

interface DataSourceWish {
    suspend fun <T> wish(clazz: Class<T>, collection: String, id: String): T
    suspend fun <T> wishs(clazz: Class<T>, collection: String): Map<String, T>
    suspend fun <T> wishList(clazz: Class<T>): Map<String, T>
}