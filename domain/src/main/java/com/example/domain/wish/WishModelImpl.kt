package com.example.domain.wish

class WishModelImpl(private val repo: WishRepository ): WishModel {
    override suspend fun getWish(collection: String, id: String): Wish {
        return repo.getWish(collection, id)
    }

    override suspend fun getWishs(collection: String): List<Wish> {
        return repo.getWishs(collection)
    }
}