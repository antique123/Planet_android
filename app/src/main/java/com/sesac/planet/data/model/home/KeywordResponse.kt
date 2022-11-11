package com.sesac.planet.data.model

import com.google.gson.annotations.SerializedName

data class KeywordResponse(
    @SerializedName("result") val result: ResultKeyword
) : BaseResponse()

data class ResultKeyword(
    @SerializedName("keyword_name") val keyword_name:String
)