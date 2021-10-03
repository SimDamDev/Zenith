package com.simdamsi.zenith.ui.zenith

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.simdamsi.zenith.R
import com.simdamsi.zenith.model.Mountain
import com.simdamsi.zenith.utils.ColorUtil
import kotlinx.android.synthetic.main.fragment_zenith.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class ZenithFragment : Fragment() {

    private val zenithViewModel: ZenithViewModel by viewModel()

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("Oncreateview", "uhm")
        return inflater.inflate(R.layout.fragment_zenith, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i("Onviewcrated", "uhm")
        super.onViewCreated(view, savedInstanceState)
        activity?.window?.statusBarColor =
            ColorUtil(view.context).convertColor(R.color.background)

        val progressBar = progressBar
        val recyclerView = recyclerView
        val layoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = layoutManager
        Log.i("before getlistmountain", "uhm")

        zenithViewModel.getListMountain().observe(viewLifecycleOwner, Observer {
            Log.i("getlistMountain", "uhm")
            val mountains: List<Mountain> = it
            recyclerView.adapter = ZenithAdapter(mountains, view.context)
            if (mountains.isNotEmpty())
                progressBar.visibility = View.GONE
        })

        /*val speedDialView = speedDial
        speedDialView.inflate(R.menu.menu_pokedex)
        speedDialView.setOnActionSelectedListener(SpeedDialView.OnActionSelectedListener { actionItem ->
            when (actionItem.id) {
                R.id.menuAllGen -> {
                    showAllGen()
                    speedDialView.close()
                    return@OnActionSelectedListener true
                }
                R.id.menuSearch -> {
                    showSearch()
                    speedDialView.close()
                    return@OnActionSelectedListener true
                }
                else -> {
                    speedDialView.close()
                    return@OnActionSelectedListener true
                }
            }
        })*/
    }

    /* private fun showAllGen() {
         val dialog = GenerationFragment()
         dialog.show(requireFragmentManager(), "")
     }

     private fun showSearch() {
         val dialog = SearchFragment()
         dialog.show(requireFragmentManager(), "")
     }*/
}
