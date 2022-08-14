package com.example.sixthmsecondhmyoutubeapp.youtube.ui.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.example.sixthmsecondhmyoutubeapp.youtube.base.BaseViewModel
import com.example.sixthmsecondhmyoutubeapp.youtube.data.network.remote.repo.Repository
import com.example.sixthmsecondhmyoutubeapp.youtube.model.Playlist

class SplashViewModel(private val repo: Repository): BaseViewModel() {

    private val _playlist = MutableLiveData<Playlist>()
    private val _result = MutableLiveData<Boolean>()

    val playlist = _result.switchMap {
        repo.getPlaylist()
    }

    val setPlaylist = _playlist.switchMap {
        repo.setPlaylist(it)
    }

    fun getPlaylist(){
        _result.value = true
    }

    fun setPlaylist(playlist: Playlist) {
        _playlist.value = playlist
    }
}