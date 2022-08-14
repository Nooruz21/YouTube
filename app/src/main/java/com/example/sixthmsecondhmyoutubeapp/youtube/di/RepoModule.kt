package com.example.sixthmsecondhmyoutubeapp.youtube.di

import com.example.sixthmsecondhmyoutubeapp.youtube.data.network.remote.repo.Repository
import org.koin.dsl.module

val repoModule = module {
    single { Repository(get(),get()) }
}