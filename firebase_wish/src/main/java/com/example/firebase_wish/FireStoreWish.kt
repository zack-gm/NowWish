package com.example.firebase_wish

import com.example.data.repository.DataSourceWish
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class FireStoreWish(val userId: String): DataSourceWish {

    val storage = Firebase.firestore

    @ExperimentalCoroutinesApi
    override suspend fun <T> wish(clazz: Class<T>, id_list: String, id: String): T {
        return storage.document("wishbase/$userId/wishlist/$id_list/list/$id")
            .get()
            .await()
            .toObject(clazz)!!
    }

    @ExperimentalCoroutinesApi
    override suspend fun <T> wishs(clazz: Class<T>, id_list: String): Map<String, T> {
        val mapWish = hashMapOf<String, T>()
        storage.document("wishbase/$userId/wishlist/$id_list/").collection("list")
            .get()
            .addOnCompleteListener {
                it.result?.forEach { document ->
                    try {
                        mapWish[document.id] = document.toObject(clazz)
                    }catch (e: Exception){}
                }
            }
            .await()
        return mapWish
    }

    @ExperimentalCoroutinesApi
    override suspend fun <T> wishList(clazz: Class<T>): Map<String, T> {
        val mapWish = hashMapOf<String, T>()
        storage.document("wishbase/$userId/").collection("wishlist")
            .get()
            .addOnCompleteListener {
                it.result?.forEach { document ->
                    try {
                        mapWish[document.id] = document.toObject(clazz)
                    }catch (e: Exception){}
                }
            }
            .await()
        return mapWish
    }
}