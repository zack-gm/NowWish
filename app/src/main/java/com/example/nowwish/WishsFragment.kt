package com.example.nowwish


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.data.WishDataRepository
import com.example.domain.wish.WishModelImpl
import com.example.firebase_wish.FireStoreWish
import com.example.presentation.wish.WishAdapter
import com.example.presentation.wish.viewmodel.WishViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.frag_wishs.*
import kotlinx.android.synthetic.main.frag_wishs.view.*

/**
 * A fragment representing a list of Items.
 */
class WishsFragment : Fragment() {

    private var wishListId: String? = null
    private val wishViewModel: WishViewModel by lazy{
        ViewModelProvider(activity?.viewModelStore!!, WishViewModel.Factory(
            WishModelImpl(WishDataRepository(
                FireStoreWish(Firebase.auth.currentUser?.uid!!))))).get(WishViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            wishListId = it.getString(WISH_LIST_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.frag_wishs, container, false)

        view.wish_list.layoutManager = LinearLayoutManager(context)

        return view
    }

    override fun onStart() {
        super.onStart()
        wishListId?.let {
            wishViewModel.loadWishs(it)
        }

        wishViewModel.wishs.observe(this, Observer {list ->
            wish_list.adapter = WishAdapter(list) { wish ->
                wishListId?.let { it ->
                    wishViewModel.loadWish(it, wish.id)
                    findNavController().navigate(R.id.action_wishFragmentMain_to_wishDatailsFragment,
                        bundleOf(WishDatailsFragment.WISH_ID to wish.id))
                }
            }
        })
    }

    companion object {

        const val WISH_LIST_ID = "wish_list_id"

        @JvmStatic
        fun newInstance(id: String) =
            WishsFragment().apply {
                arguments = bundleOf(WISH_LIST_ID to  id)
            }
    }
}