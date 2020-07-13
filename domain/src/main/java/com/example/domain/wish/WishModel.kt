package com.example.domain.wish

interface WishModel {
    suspend fun getWish(collection: String, id: String): Wish
    suspend fun getWishs(collection: String): List<Wish>
}