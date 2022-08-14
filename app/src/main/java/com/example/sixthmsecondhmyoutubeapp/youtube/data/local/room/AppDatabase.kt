package com.example.sixthmsecondhmyoutubeapp.youtube.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.sixthmsecondhmyoutubeapp.youtube.data.converters.Converters
import com.example.sixthmsecondhmyoutubeapp.youtube.model.Playlist

@Database(entities = [Playlist::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase :RoomDatabase() {
    abstract fun dao(): Dao
}