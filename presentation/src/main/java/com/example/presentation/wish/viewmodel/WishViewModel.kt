package com.example.presentation.wish.viewmodel

import androidx.lifecycle.*
import com.example.domain.wish.Wish
import com.example.domain.wish.WishModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WishViewModel(
    private val wishModel: WishModel
): ViewModel() {

    var wishs = MutableLiveData<List<Wish>>()

    fun loadWishs(id_list: String){
        if (id_list.isNotEmpty()) {
            viewModelScope.launch {
                wishs.value = withContext(Dispatchers.IO) {
                    wishModel.getWishs(id_list)
                }
            }
        }
    }

    var wish = MutableLiveData<Wish>()

    fun loadWish(id_list: String, id: String){
        viewModelScope.launch {
            wish.value = withContext(Dispatchers.IO) {
                wishModel.getWish(id_list, id)
            }
        }
    }

    class Factory(
        private val wishModel: WishModel
    ): ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(WishModel::class.java).newInstance(wishModel)
        }
    }
}