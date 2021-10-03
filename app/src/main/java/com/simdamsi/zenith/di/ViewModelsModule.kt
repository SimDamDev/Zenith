package com.simdamsi.zenith.di

import com.simdamsi.zenith.ui.home.HomeViewModel
import com.simdamsi.zenith.ui.zenith.ZenithViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    //viewModel { DashboardViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { ZenithViewModel(get(), get()) }

}