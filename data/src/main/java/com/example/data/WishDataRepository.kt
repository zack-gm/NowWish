package com.example.data

import com.example.data.repository.DataSourceWish
import com.example.domain.wish.Wish
import com.example.domain.wish.WishList
import com.example.domain.wish.WishRepository

class WishDataRepository(val datasource: DataSourceWish): WishRepository {
    override fun addWish(wish: Wish) {
    }

    override fun editWish(id: String) {
    }

    override fun deleteWish(id: String) {
    }

    override suspend fun getWishs(id: String): List<Wish> {
        return datasource.wishs(Wish::class.java, id).map {
                it.value.id = it.key
                it.value
            }
    }

    override suspend fun getWishList(): List<WishList> {
        return datasource.wishList(WishList::class.java).map {
            it.value.id = it.key
            it.value
        }
    }

    override suspend fun getWish(collection: String, id: String): Wish {
        return datasource.wish(Wish::class.java, collection, id).apply { this.id = id }
    }

}