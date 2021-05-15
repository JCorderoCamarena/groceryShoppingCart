package com.jorgecamarena.shoppingcart.presentation.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jorgecamarena.shoppingcart.presentation.ui.theme.ShoppingCartTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutFragment : Fragment() {

    private lateinit var aboutViewModel: AboutViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        aboutViewModel =
                ViewModelProvider(this).get(AboutViewModel::class.java)
        return ComposeView(requireContext()).apply { 
            setContent {
                ShoppingCartTheme {
                    AboutView()
                }
            }
        }
    }
}