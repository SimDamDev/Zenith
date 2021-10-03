package com.simdamsi.zenith.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.simdamsi.zenith.R
import com.simdamsi.zenith.model.Menu


class HomeViewModel(private val context: Context) : ViewModel() {

    private val listMenu = MutableLiveData<List<Menu>>()

    fun getListMenu(): LiveData<List<Menu>> {
        listMenu.value = listOf(
            Menu(1, "Sommets", R.color.fortuna_gold),
            Menu(1, "Massifs", R.color.fortuna_gold),
            Menu(1, "Pays", R.color.fortuna_gold),
            Menu(1, "???", R.color.fortuna_gold)
        )
        return listMenu
    }

}