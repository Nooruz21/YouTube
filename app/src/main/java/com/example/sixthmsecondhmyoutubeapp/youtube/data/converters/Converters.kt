package com.example.sixthmsecondhmyoutubeapp.youtube.data.converters

import androidx.room.TypeConverter
import com.example.sixthmsecondhmyoutubeapp.youtube.model.Item
import com.example.sixthmsecondhmyoutubeapp.youtube.model.PageInfo
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*


object Converters {
    val gson = Gson()

    @TypeConverter
    fun stringToItems(data: String?): List<Item?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object : TypeToken<List<Item?>?>() {}.type
        return gson.fromJson<List<Item?>>(data, listType)
    }

    @TypeConverter
    fun itemsToString(myObjects: List<Item?>?): String? {
        return gson.toJson(myObjects)
    }

    @TypeConverter
    fun stringToPageIfo(data:String?):PageInfo?{
        return gson.fromJson(data,PageInfo::class.java)
    }

    @TypeConverter
    fun pageInfoToString(pageInfo: PageInfo): String? {
        return gson.toJson(pageInfo)
    }
}