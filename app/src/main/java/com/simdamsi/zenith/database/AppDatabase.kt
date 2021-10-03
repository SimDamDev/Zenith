package com.simdamsi.zenith.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.simdamsi.zenith.database.dao.ZenithDAO
import com.simdamsi.zenith.model.Mountain

@Database(entities = [Mountain::class], version = 1, exportSchema = false)

abstract class AppDatabase : RoomDatabase() {

    abstract fun zenithDAO(): ZenithDAO

}
