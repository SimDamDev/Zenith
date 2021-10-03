package com.simdamsi.zenith.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.simdamsi.zenith.model.Mountain

@Dao
interface ZenithDAO {

    @Query("SELECT * FROM mountain WHERE id = :id")
    fun getById(id: String?): LiveData<Mountain>

    @Query("SELECT * FROM mountain")
    fun all(): LiveData<List<Mountain>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(mountain: List<Mountain>)

    @Query("DELETE FROM mountain")
    fun deleteAll()

    @Delete
    fun delete(model: Mountain)

}