package com.example.sixthmsecondhmyoutubeapp.youtube.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel:ViewModel() {

    val progress = MutableLiveData<Boolean>()
}