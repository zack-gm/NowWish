package com.example.presentation.wish.viewmodel

import androidx.lifecycle.*
import com.example.domain.wish.Wish
import com.example.domain.wish.WishList
import com.example.domain.wish.WishListModel
import kotlinx.coroutines.Dispatchers

class WishListViewModel(
    private val wishListModel: WishListModel
): ViewModel() {

    var wishList = liveData(Dispatchers.IO) {
        emit(wishListModel.getWishList("mylist"))
    }

    class Factory(
        private val wishModel: WishListModel
    ): ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(WishListModel::class.java).newInstance(wishModel)
        }
    }
}