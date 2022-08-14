package com.example.sixthmsecondhmyoutubeapp.youtube.di

import com.example.sixthmsecondhmyoutubeapp.youtube.ui.playlist.PlaylistViewModel
import com.example.sixthmsecondhmyoutubeapp.youtube.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PlaylistViewModel(get()) }
    viewModel { SplashViewModel(get()) }
}