package com.example.sixthmsecondhmyoutubeapp.youtube.data.network.remote.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.sixthmsecondhmyoutubeapp.youtube.data.domain.Resource
import com.example.sixthmsecondhmyoutubeapp.youtube.data.local.room.AppDatabase
import com.example.sixthmsecondhmyoutubeapp.youtube.data.network.remote.ApiService
import com.example.sixthmsecondhmyoutubeapp.youtube.model.ErrorResponse
import com.example.sixthmsecondhmyoutubeapp.youtube.model.Playlist
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers

class Repository(private val apiService: ApiService,private val db:AppDatabase) {

    fun getPlaylist(): LiveData<Resource<Playlist?>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val result = apiService.getPlaylist()
        if (result.isSuccessful) {
            emit(Resource.success(result.body()))
        } else {
            val jObjError = result.errorBody()?.string()
            val gson = Gson()
            val data = gson.fromJson(jObjError, ErrorResponse::class.java)
            emit(Resource.error(data.error?.message.toString()))
        }
    }

    fun getLocalPlaylist(): LiveData<Resource<Playlist?>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val result = db.dao().getPlaylist()
        emit(Resource.success(result))
    }

    fun setPlaylist(playlist: Playlist): LiveData<Resource<Boolean>> = liveData(Dispatchers.IO) {
        db.dao().insert(playlist)
        emit(Resource.success(true))
    }
}