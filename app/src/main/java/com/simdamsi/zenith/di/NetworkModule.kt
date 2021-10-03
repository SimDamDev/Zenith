package com.simdamsi.zenith.di

import org.koin.dsl.module


val networkModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl()
            .addConvertFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create<ZenithService>()
    }
}