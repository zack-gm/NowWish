package com.example.nowwish

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.frag_login.*
import kotlinx.android.synthetic.main.frag_login.view.*

class LoginFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.frag_login, container, false)
        auth = Firebase.auth

        view.btn_sign_in.setOnClickListener {
            auth.signInWithEmailAndPassword(et_login.text.toString(), et_password.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        FirebaseAuth.getInstance().currentUser?.getIdToken(false)?.result?.token
                        findNavController().navigate(R.id.action_loginFragment_to_wishListFragment)
                    }
                    else{

                    }
                }
        }

        view.btn_create.setOnClickListener {
            /*auth.createUserWithEmailAndPassword(et_login.text.toString(), et_password.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful){

                    }
                    else{

                    }
                }*/
            findNavController().navigate(R.id.my_dialog_fragment)
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser

//        if(currentUser != null)
//            findNavController().navigate(R.id.action_loginFragment_to_wishFragment)

        // проверка входа пользователя
//        updateUI (CurrentUser)
    }
}