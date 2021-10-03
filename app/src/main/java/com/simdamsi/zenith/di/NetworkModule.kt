package com.simdamsi.zenith.di

import com.simdamsi.zenith.repository.ZenithService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


val networkModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/simdamsi/a3d5fcd36822de06677017ac4d61545b/raw/de96dc4b2912e49f51dde7daeead717821d06e07/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create<ZenithService>()
    }
}