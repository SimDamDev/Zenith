package com.simdamsi.zenith.di

import androidx.room.Room
import com.simdamsi.zenith.R
import com.simdamsi.zenith.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            androidApplication().baseContext.getString(R.string.app_name)
        ).fallbackToDestructiveMigration().build()
    }
    single {
        get<AppDatabase>().zenithDAO()
    }
}