package com.example.domain.wish

class WishListModelImpl(private val repo: WishRepository ): WishListModel {
    override suspend fun getWishList(collection: String): List<WishList> {
        return repo.getWishList()
    }
}