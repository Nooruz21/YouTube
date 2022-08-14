package com.example.sixthmsecondhmyoutubeapp.youtube.ui.playlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.example.sixthmsecondhmyoutubeapp.youtube.base.BaseViewModel
import com.example.sixthmsecondhmyoutubeapp.youtube.data.network.remote.repo.Repository

class PlaylistViewModel(private val repo: Repository) : BaseViewModel() {

    private val _local = MutableLiveData<Boolean>()

    val localPlaylist = _local.switchMap {
        repo.getLocalPlaylist()
    }

    fun getLocalPlaylist(){
        _local.value = true
    }

}