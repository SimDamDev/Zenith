package com.simdamsi.zenith.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.simdamsi.zenith.R
import com.simdamsi.zenith.model.Menu
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerViewMenu = recyclerViewMenu

        recyclerViewMenu.layoutManager = GridLayoutManager(context, 1)


        homeViewModel.getListMenu().observe(viewLifecycleOwner, Observer {
            val items: List<Menu> = it
            recyclerViewMenu.adapter = MenuAdapter(items, view.context)
        })

    }
}
