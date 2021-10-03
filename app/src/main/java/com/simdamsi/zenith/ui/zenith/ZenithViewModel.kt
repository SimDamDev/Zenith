package com.simdamsi.zenith.ui.zenith

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.simdamsi.zenith.database.dao.ZenithDAO
import com.simdamsi.zenith.model.Mountain
import com.simdamsi.zenith.repository.ZenithService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread


class ZenithViewModel(private val zenithDAO: ZenithDAO, private val zenithService: ZenithService) :
    ViewModel() {

    init {
        initNetworkRequest()
    }

    private fun initNetworkRequest() {
        val call = zenithService.get()
        call.enqueue(object : Callback<List<Mountain>?> {
            override fun onResponse(
                call: Call<List<Mountain>?>?,
                response: Response<List<Mountain>?>?
            ) {
                response?.body()?.let { mountain: List<Mountain> ->
                    thread {
                        zenithDAO.add(mountain)
                    }
                }
            }

            override fun onFailure(call: Call<List<Mountain>?>?, t: Throwable?) {
                // TODO handle failure
            }
        })
    }

    fun getListMountain(): LiveData<List<Mountain>> {
        return zenithDAO.all()
    }
}
