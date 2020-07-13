package com.example.nowwish

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()

//        if(Firebase.auth.currentUser == null)
            findNavController().navigate(R.id.action_global_loginFragment)
//        else
//            findNavController().navigate(R.id.action_mainFragment_to_wishFragmentMain)
    }

    companion object{

        @JvmStatic
        fun newInstance() = MainFragment().apply {

        }
    }
}