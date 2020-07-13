package com.example.nowwish

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.d_my_dialog.view.*

class MyDialog: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.d_my_dialog, container, false)
        view.btn_dlg_ok.setOnClickListener {
            Firebase.auth.signOut()
            findNavController().popBackStack()
        }
        return view
    }
}