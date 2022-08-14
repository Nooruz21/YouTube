package com.example.sixthmsecondhmyoutubeapp.youtube

import android.app.Application
import com.example.sixthmsecondhmyoutubeapp.youtube.data.network.networkModule
import com.example.sixthmsecondhmyoutubeapp.youtube.di.dbModule
import com.example.sixthmsecondhmyoutubeapp.youtube.di.repoModule
import com.example.sixthmsecondhmyoutubeapp.youtube.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(listOf(networkModule, dbModule, repoModule, viewModelModule))
        }
    }
}