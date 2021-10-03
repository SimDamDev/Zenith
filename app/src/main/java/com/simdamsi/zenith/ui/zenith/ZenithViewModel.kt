package com.simdamsi.zenith.ui.zenith

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.simdamsi.zenith.database.dao.ZenithDAO
import com.simdamsi.zenith.model.Mountain
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

//TODO (Pokemon) service appeler csvreader o quelquechose du genre
class ZenithViewModel(private val zenithDAO: ZenithDAO, private val service: Service) :
    ViewModel() {

    init {
        Log.i("init", "uhm")
        readCvsMountain()
    }

    private fun readCvsMountain() {
        Log.i("readCvsMountain", "uhm")
        var filereader: BufferedReader? = null
        val mountains = mutableListOf<Mountain>()
        val mountain = Mountain()

        try {
            var line: String?

            filereader = BufferedReader(FileReader("mountain.json"))

            filereader.readLine()

            line = filereader.readLine()

            while (line != null) {
                val tokens = line.split("|")
                if (tokens.isNotEmpty()) {
                    mountain.id = tokens[0]
                    mountain.name = tokens[1]
                    mountain.alt = tokens[2].toDouble()
                    mountain.massif = tokens[3]
                    mountain.coords = tokens[4]
                    mountain.pays = tokens[5]
                    mountain.province = tokens[6]
                    mountains.add(mountain)
                    line = filereader.readLine()
                }
            }
        } catch (e: Exception) {
            Log.e("CSV reader", "Reading CSV Error!")
            e.printStackTrace()
        } finally {
            try {
                filereader!!.close()
            } catch (e: IOException) {
                Log.e("CSV reader", "Closing Filereader Error!")
            }
        }
        zenithDAO.add(mountains)
    }

    fun getListMountain(): LiveData<List<Mountain>> {
        return zenithDAO.all()
    }
}
