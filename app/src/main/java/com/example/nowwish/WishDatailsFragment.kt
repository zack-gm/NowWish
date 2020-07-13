package com.example.nowwish

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.data.WishDataRepository
import com.example.domain.wish.WishModelImpl
import com.example.firebase_wish.FireStoreWish
import com.example.presentation.wish.viewmodel.WishViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class WishDatailsFragment: Fragment() {

    private val wishModeView: WishViewModel by lazy {
        ViewModelProvider(activity?.viewModelStore!!, WishViewModel.Factory(
            WishModelImpl(WishDataRepository(
                FireStoreWish(Firebase.auth.currentUser?.uid!!))))).get(WishViewModel::class.java)
    }

    private var currentIdWish = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.frag_wish_details, container, false)
        return view
    }

    override fun onStart() {
        super.onStart()
        wishModeView.wish.let {
            it.observe(this, Observer {wish ->
                view?.findViewById<TextView>(com.example.presentation.R.id.id_wish_list)?.text = wish.id
                view?.findViewById<TextView>(com.example.presentation.R.id.name_wish_list)?.text = wish.title
                view?.findViewById<TextView>(com.example.presentation.R.id.description_wish_list)?.text = wish.description
            })
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        arguments.let {
            currentIdWish = it?.getString(WISH_ID) ?: ""
        }
    }

    companion object{
        const val WISH_ID = "wish_id"

        @JvmStatic
        fun newInstance(wishId: String) =
            WishDatailsFragment().apply {
                arguments = bundleOf(WISH_ID to wishId)
            }
    }
}