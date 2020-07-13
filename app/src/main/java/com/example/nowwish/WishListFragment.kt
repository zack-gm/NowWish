package com.example.nowwish


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.data.WishDataRepository
import com.example.domain.wish.WishListModelImpl
import com.example.firebase_wish.FireStoreWish
import com.example.presentation.wish.WishListAdapter
import com.example.presentation.wish.viewmodel.WishListViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.frag_wish_list.*
import kotlinx.android.synthetic.main.frag_wish_list.view.*

/**
 * A fragment representing a list of Items.
 */
class WishListFragment : Fragment() {

    private val wishListViewModel: WishListViewModel by lazy{
        ViewModelProvider(activity?.viewModelStore!!, WishListViewModel.Factory(
            WishListModelImpl(WishDataRepository(
                FireStoreWish(Firebase.auth.currentUser?.uid!!))))).get(WishListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.frag_wish_list, container, false)

        view.list_wish.layoutManager = LinearLayoutManager(context)

        return view
    }

    override fun onStart() {
        super.onStart()
        wishListViewModel.wishList.observe(this, Observer {
            list_wish.adapter = WishListAdapter(it) { wishList ->
                findNavController().navigate(R.id.action_wishListFragment_to_wish_navigator,
                    bundleOf(WishsFragment.WISH_LIST_ID to wishList.id))
            }
        })
    }

    companion object {

        @JvmStatic
        fun newInstance(columnCount: Int) =
            WishListFragment().apply {
            }
    }
}