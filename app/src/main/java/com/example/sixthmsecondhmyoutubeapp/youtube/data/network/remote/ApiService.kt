package com.example.sixthmsecondhmyoutubeapp.youtube.data.network.remote

import com.example.sixthmsecondhmyoutubeapp.BuildConfig
import com.example.sixthmsecondhmyoutubeapp.youtube.model.Playlist
import com.example.sixthmsecondhmyoutubeapp.youtube.utils.Const
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    suspend fun getPlaylist(
        @Query("part") part:String = Const.PART,
        @Query("channelId") channelId:String = Const.CHANNEL_ID,
        @Query("key") key:String = BuildConfig.API_KEY
    ) : Response<Playlist>

}