package com.example.sixthmsecondhmyoutubeapp.youtube.di

import android.content.Context
import androidx.room.Room
import com.example.sixthmsecondhmyoutubeapp.youtube.data.local.room.AppDatabase
import org.koin.dsl.module

val dbModule = module {
    single { provideDatabase(get()) }
}
fun provideDatabase(context: Context): AppDatabase{
    return Room.databaseBuilder(context, AppDatabase::class.java, "database")
        .build()
}