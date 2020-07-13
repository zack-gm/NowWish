package com.example.domain.wish

import com.example.domain.wish.Wish

interface WishRepository {
    fun addWish(wish: Wish)
    fun editWish(id: String)
    fun deleteWish(id: String)
    suspend fun getWishs(id: String) : List<Wish>
    suspend fun getWishList() : List<WishList>
    suspend fun getWish(collection: String, id: String) : Wish
}