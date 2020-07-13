package com.example.domain.wish

interface WishListModel {
    suspend fun getWishList(collection: String): List<WishList>
}