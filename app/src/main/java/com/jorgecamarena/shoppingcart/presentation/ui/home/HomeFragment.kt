package com.jorgecamarena.shoppingcart.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jorgecamarena.shoppingcart.presentation.ui.theme.ShoppingCartTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        return ComposeView(requireContext()).apply {
            setContent {
                ShoppingCartTheme {
                    Scaffold(
                        topBar = {
                            TopAppBar {
                                Text(text = "Home")
                            }
                        }
                    ) {
                        HomeView()
                    }
                }
            }
        }
    }
}