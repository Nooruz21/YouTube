package com.example.sixthmsecondhmyoutubeapp.youtube.model

data class ErrorResponse(
    val error:ErrorBody? = null
)

data class ErrorBody(
    val code:Int?=null,
    val message: String? = null
)