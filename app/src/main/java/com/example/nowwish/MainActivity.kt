package com.example.nowwish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.data.WishDataRepository
import com.example.domain.wish.WishModelImpl
import com.example.firebase_wish.FireStoreWish
import com.example.presentation.wish.viewmodel.WishViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    val wishViewModel: WishViewModel by lazy {
        ViewModelProvider(this, WishViewModel.Factory(
            WishModelImpl(WishDataRepository(
                FireStoreWish(Firebase.auth.currentUser?.uid!!))))).get(WishViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_main)
    }
}