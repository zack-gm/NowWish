package com.example.presentation.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.user.User
import com.example.domain.user.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(
    private val userModel: UserModel
): ViewModel() {

    var state = MutableLiveData<AuthState>()
    var user = MutableLiveData<User>()

    init {
        state.value = AuthState.UNAUTH
    }

    enum class AuthState{
        UNAUTH,
        AUTH,
    }

    fun authenticate(login: String, password: String){
        viewModelScope.launch {
            user.value = withContext(Dispatchers.IO) {
                userModel.signIn(login, password)
            }
        }
    }
}