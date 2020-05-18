package com.example.nowwish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        btn_sign_in.setOnClickListener {
            auth.signInWithEmailAndPassword(et_login.text.toString(), et_password.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful){

                    }
                    else{

                    }
                }
        }

        btn_create.setOnClickListener {
            auth.createUserWithEmailAndPassword(et_login.text.toString(), et_password.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful){

                    }
                    else{

                    }
                }
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser

        // проверка входа пользователя
//        updateUI (CurrentUser)
    }
}